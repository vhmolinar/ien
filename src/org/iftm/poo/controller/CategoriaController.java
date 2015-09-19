/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.controller;

import java.util.List;

import org.iftm.poo.model.domain.Categoria;
import org.iftm.poo.negocio.CategoriaService;

/**
 *
 * @author vhmolinar
 */
public class CategoriaController {
 
    private final CategoriaService categoriaService;
    
    public CategoriaController(){
        categoriaService = new CategoriaService();
    }
    
    public Categoria novoCategoria(String descricaoCategoria) throws Exception {
        Categoria categoria = new Categoria(descricaoCategoria);
        
        return categoriaService.salvarAtualizarCategoria(categoria);
    }
    
    public List<Categoria> consultaCategorias(String descricaoCategoria) throws Exception {
        Categoria categoria = new Categoria(descricaoCategoria);
        return categoriaService.pesquisarPorExemplo(categoria);
    }
    
    public List<Categoria> buscarTodosCategorias() throws Exception{
        return categoriaService.pesquisarTodos();
    }
    
    public List<Categoria> pesquisarPorExemplo(Integer codCategoria) throws Exception{ 
        Categoria categoria = new Categoria();
        categoria.setCodCategoria(codCategoria);
        return categoriaService.pesquisarPorExemplo(categoria);
    }
	
}
