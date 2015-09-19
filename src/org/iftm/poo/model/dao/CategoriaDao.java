/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import java.util.List;

import org.iftm.poo.model.domain.Categoria;

/**
 *
 * @author vhmolinar
 */
public class CategoriaDao extends TemplateDao<Categoria>{
	
    public CategoriaDao(){
        this.tipoEntidade = Categoria.class;
    }
      
    public Categoria buscaPorDescricao(String descricao) throws Exception{
        Categoria exemplo = new Categoria(descricao);
        List<Categoria> resultado = pesquisar(exemplo);
        if(resultado.isEmpty()){
            return null;
        }else{
            return resultado.get(0);
        }
    }
}
