/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import java.lang.reflect.Field;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

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
        Session session = (Session) em.getDelegate();
        Example example = Example.create(entity).excludeZeroes();
        Criteria criteria = session.createCriteria(tipoEntidade).add(example);
        return criteria.list();
    }
    
    public T salvarAtualizar(EntityManager em, T entity) throws Exception{
        return TemplateDao.this.salvarAtualizarImpl(em, entity);
    }
    
    public T salvarAtualizar(T entity) throws Exception{
        return (T) this.operacaoTransacional(new ComandoPersistencia() {
            @Override
            public T execute(EntityManager em) throws Exception {
                return TemplateDao.this.salvarAtualizarImpl(em, entity);
            }
        });
    }
    
    public List<T> pesquisar(T entity) throws Exception{
        return (List<T>) this.operacaoTransacional(new ComandoPersistencia() {
            @Override
            public Object execute(EntityManager em) throws Exception {
                return TemplateDao.this.pesquisar(em, entity);
            }
        });
    }
    
    public T excluir(T entity) throws Exception{
        return (T) this.operacaoTransacional(new ComandoPersistencia() {
            @Override
            public Object execute(EntityManager em) throws Exception {
                em.remove(entity);
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
