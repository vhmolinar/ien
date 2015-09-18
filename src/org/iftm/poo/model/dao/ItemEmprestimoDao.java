/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import javax.persistence.EntityManager;
import org.iftm.poo.model.domain.ItemEmprestimo;

/**
 *
 * @author Laura
 */
public class ItemEmprestimoDao extends TemplateDao<ItemEmprestimo>{
        
    public ItemEmprestimoDao(){
        this.tipoEntidade = ItemEmprestimo.class;
    }

    @Override
    protected ItemEmprestimo salvarAtualizarImpl(EntityManager em, ItemEmprestimo itemEmprestimo) throws Exception {
        if(itemEmprestimo.getCodItemEmprestimo() != null){
            itemEmprestimo = em.merge(itemEmprestimo);
        }
        em.persist(itemEmprestimo);
        return itemEmprestimo;
    }
    
}