/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.controller;

import java.util.List;

import org.iftm.poo.model.domain.Autor;
import org.iftm.poo.negocio.AutorService;

/**
 *
 * @author vhmolinar
 */
public class AutorController {
    
    private final AutorService autorService;
    
    public AutorController(){
        autorService = new AutorService();
    }
    
    public Autor novoAutor(String nomeAutor) throws Exception {
        Autor autor = new Autor(nomeAutor);
        
        return autorService.salvarAtualizarAutor(autor);
    }
    
    public List<Autor> consultaAutores(String nomeAutor) throws Exception {
        Autor autor = new Autor(nomeAutor);
        return autorService.pesquisarPorExemplo(autor);
    }
    
    public List<Autor> buscarTodosAutors() throws Exception{
        return autorService.pesquisarTodos();
    }
    
    public List<Autor> pesquisarPorExemplo(Integer codAutor) throws Exception{ 
        Autor autor = new Autor();
        autor.setCodAutor(codAutor);
        return autorService.pesquisarPorExemplo(autor);
    }
}
