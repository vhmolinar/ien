/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.iftm.poo.model.domain.Emprestimo;
import org.iftm.poo.model.domain.ItemEmprestimo;


/**
 *
 * @author vhmolinar
 */
public class EmprestimoDao extends TemplateDao<Emprestimo>{
    
    public EmprestimoDao(){
        this.tipoEntidade = Emprestimo.class;
    }

    @Override
    protected Emprestimo salvarAtualizarImpl(EntityManager em, Emprestimo emprestimo) throws Exception {        
        if(emprestimo.getCodEmprestimo() != null){
            emprestimo = em.merge(emprestimo);
        }
        em.persist(emprestimo);
        return emprestimo;
    }
    
    @SuppressWarnings("unchecked")
	public List<ItemEmprestimo> itensEmprestimo(Emprestimo e) throws Exception{
        return (List<ItemEmprestimo>) operacaoTransacional(new ComandoPersistencia() {
            @Override
            public Object execute(EntityManager em) throws Exception {
                Query query = em.createQuery("select e from Emprestimo e join fetch e.itens where e.codEmprestimo = :codEmprestimo", Emprestimo.class);
                query.setParameter("codEmprestimo", e.getCodEmprestimo());
                return ((Emprestimo)query.getSingleResult()).getItens();
            }
        });
    }
}
