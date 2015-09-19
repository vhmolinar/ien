/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 * Design patterns:
 * 
 * Template Method e Command
 * 
 * @author vhmolinar
 * @param <T>
 */
public abstract class TemplateDao<T> {
    
    protected Class<T> tipoEntidade;
    
    protected T salvarAtualizarImpl(EntityManager em, T entity) throws Exception{
        Integer cod = null;
        for(Field field: entity.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(Id.class)){
                field.setAccessible(true);
                cod = (Integer) field.get(entity);
            }
        }            
        if(cod != null){
            entity = em.merge(entity);
        }
        em.persist(entity);
        return entity;
    }
    
    protected List<T> pesquisar(EntityManager em, T entity) throws Exception{
        Class<T> clazz = tipoEntidade;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> r = cq.from(clazz);
        Predicate p = cb.conjunction();
        Metamodel mm = em.getMetamodel();
        EntityType<T> et = mm.entity(clazz);
        Set<Attribute<? super T, ?>> attrs = et.getAttributes();
        
        for (Attribute<? super T, ?> a: attrs) {
            String name = a.getName();
            String javaName = a.getJavaMember().getName();
            String getter = "get" + javaName.substring(0,1).toUpperCase() + javaName.substring(1);
            Method m = clazz.getMethod(getter, (Class<?>[]) null);
            if (m.invoke(entity, (Object[]) null) !=  null)
                p = cb.and(p, cb.equal(r.get(name), m.invoke(entity, (Object[]) null)));
        }
        cq.select(r).where(p);
        TypedQuery<T> query = em.createQuery(cq);
        
        return query.getResultList();
    }
    
    public T salvarAtualizar(EntityManager em, T entity) throws Exception{
        return TemplateDao.this.salvarAtualizarImpl(em, entity);
    }
    
    @SuppressWarnings("unchecked")
	public T salvarAtualizar(T entity) throws Exception{
        return (T) this.operacaoTransacional(new ComandoPersistencia() {
            @Override
            public T execute(EntityManager em) throws Exception {
                return TemplateDao.this.salvarAtualizarImpl(em, entity);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
	public List<T> pesquisar(T entity) throws Exception{
        return (List<T>) this.operacaoTransacional(new ComandoPersistencia() {
            @Override
            public Object execute(EntityManager em) throws Exception {
                return TemplateDao.this.pesquisar(em, entity);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
	public T excluir(T entity) throws Exception{
        return (T) this.operacaoTransacional(new ComandoPersistencia() {
            @Override
            public Object execute(EntityManager em) throws Exception {
                em.remove(em.merge(entity));
                return entity;
            }
        }); 
    }
    
    protected Object operacaoTransacional(ComandoPersistencia comando) throws Exception{
        EntityManager em = Conexao.get().createEM();
        em.getTransaction().begin();
        try{            
            Object resultado = comando.execute(em);
            em.getTransaction().commit();
            return resultado;
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        }finally{            
            em.close();
        }
    }
    
    public abstract static class ComandoPersistencia{
        public abstract Object execute(EntityManager em) throws Exception;
    }
}
