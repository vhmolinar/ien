/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.iftm.poo.model.domain.ItemLivro;
import org.iftm.poo.model.domain.Livro;

/**
 *
 * @author vhmolinar
 */
public class ItemLivroDao extends TemplateDao<ItemLivro>{
    
    public ItemLivroDao(){
        this.tipoEntidade = ItemLivro.class;
    }

    @Override
    protected ItemLivro salvarAtualizarImpl(EntityManager em, ItemLivro itemLivro) throws Exception {
        if(itemLivro.getCodItemLivro()!= null){
            itemLivro = em.merge(itemLivro);
        }
        em.persist(itemLivro);
        return itemLivro;
    }
    
    public List<ItemLivro> itensLivro(Livro livro) throws Exception {
        return (List<ItemLivro>) this.operacaoTransacional(new ComandoPersistencia(){
            @Override
            public Object execute(EntityManager em) throws Exception {
                Query query = em.createQuery("select from ItemLivro i where livro.codLivro = :codLivro");
                query.setParameter("codLivro", livro.getCodLivro());
                return query.getResultList();
            }            
        });
    }
    
}
