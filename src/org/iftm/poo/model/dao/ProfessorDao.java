/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import javax.persistence.EntityManager;
import org.iftm.poo.model.domain.Professor;

/**
 *
 * @author Laura
 */
public class ProfessorDao extends TemplateDao<Professor>{
    
    public ProfessorDao(){
        this.tipoEntidade = Professor.class;
    }
    
        @Override
    protected Professor salvarAtualizarImpl(EntityManager em, Professor professor) throws Exception {
        if(professor.getCodPessoa() != null){
            professor = em.merge(professor);
        }
        em.persist(professor);
        return professor;
    }
    
}