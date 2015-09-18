/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.controller;

import java.util.List;
import org.iftm.poo.model.domain.Autor;
import org.iftm.poo.model.domain.Categoria;
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.Usuario;
import org.iftm.poo.negocio.LivroService;

/**
 *
 * @author vhmolinar
 */
public class LivroController {
    
    private final LivroService livroService;
    
    public LivroController(){
        livroService = new LivroService();
    }
    
    public Livro novoLivro(String nome, String edicao, Integer ano, Integer qtde, String nomeAutor, String descricaoCategoria) throws Exception {
        Categoria categoria = new Categoria(descricaoCategoria);
        Autor autor = new Autor(nomeAutor);
        Livro livro = new Livro(nome, edicao, ano, categoria, autor);
        
        return livroService.salvarAtualizarLivro(livro, qtde);
    }
    
    public List<Livro> consultaLivros(String nomeLivro, String edicao, Integer ano, String nomeAutor, String descricaoCategoria) throws Exception {
        Categoria categoria = new Categoria(descricaoCategoria);
        Autor autor = new Autor(nomeAutor);
        Livro exemplo = new Livro(nomeLivro, edicao, ano, categoria, autor);
        return livroService.pesquisarPorExemplo(exemplo);
    }
    
    public List<Livro> buscarLivrosEmprestimoUsuario(Usuario usuario) throws Exception{
        return livroService.buscarLivrosEmprestimoUsuario(usuario);
    }
    
    public List<Livro> buscarTodosLivros() throws Exception{
        return livroService.pesquisarTodos();
    }
    
    public List<Livro> pesquisarPorExemplo(Integer codLivro) throws Exception{ 
        Livro livro = new Livro();
        livro.setCodLivro(codLivro);
        return livroService.pesquisarPorExemplo(livro);
    }
}
