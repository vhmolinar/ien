/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import javax.persistence.EntityManager;
import org.iftm.poo.model.domain.Aluno;

/**
 *
 * @author Laura
 */
public class AlunoDao extends TemplateDao<Aluno>{
   
     public AlunoDao(){
        this.tipoEntidade = Aluno.class;
    }

    @Override
    protected Aluno salvarAtualizarImpl(EntityManager em, Aluno aluno) throws Exception {
        if(aluno.getCodPessoa() != null){
            aluno = em.merge(aluno);
        }
        em.persist(aluno);
        return aluno;
    }
    
}