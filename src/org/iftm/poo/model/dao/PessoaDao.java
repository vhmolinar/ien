/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import javax.persistence.EntityManager;
import org.iftm.poo.model.domain.Pessoa;

/**
 *
 * @author vhmolinar
 */
public class PessoaDao extends TemplateDao<Pessoa> {
    
    public PessoaDao(){
        this.tipoEntidade = Pessoa.class;
    }

    @Override
    protected Pessoa salvarAtualizarImpl(EntityManager em, Pessoa pessoa) throws Exception {
        if(pessoa.getCodPessoa() != null){
            pessoa = em.merge(pessoa);
        }
        em.persist(pessoa);
        return pessoa;
    }
    
}
