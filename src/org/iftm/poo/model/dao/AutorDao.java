/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import java.util.List;

import org.iftm.poo.model.domain.Autor;

/**
 *
 * @author vhmolinar
 */
public class AutorDao extends TemplateDao<Autor>{
    
    public AutorDao(){
        this.tipoEntidade = Autor.class;
    }
    
    public Autor buscaPorNome(String nomeAutor) throws Exception{
        Autor exemplo = new Autor(nomeAutor);
        List<Autor> resultado = pesquisar(exemplo);
        if(resultado.isEmpty()){
            return null;
        }else{
            return resultado.get(0);
        }
    }
}
