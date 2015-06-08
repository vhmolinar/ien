/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.main;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.iftm.poo.controller.LivroController;
import org.iftm.poo.controller.UsuarioController;
import org.iftm.poo.model.domain.Administrador;
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.Pessoa;
import org.iftm.poo.model.domain.TurnoBiblioteca;
import org.iftm.poo.model.domain.Usuario;

/**
 *
 * @author vhmolinar
 */
class UC017 extends UC {
    
    private LivroController livroController;
    private UsuarioController usuarioController;
    
    // Credenciais usuario caso de uso
    private String login, senha;
    
    @Override
    public UC preparaBase() {
        livroController = new LivroController();
        usuarioController = new UsuarioController();
        
        try {
            /** Cria um usuario base e pega as credenciais**/
            Pessoa pessoa = new Administrador(TurnoBiblioteca.Tarde, "João Carlos", "200.123.405-95");
            Usuario usuario = usuarioController.cadastraUsuario("joao.carlos", "123456", pessoa);
            login = usuario.getLogin();
            senha = usuario.getSenha();
            
            /** Cria livros base para realizacao do caso de uso**/
            livroController.novoLivro("POO", "1", 2015, 10, "Autor POO","Programação de software");
            livroController.novoLivro("Psicologia Analítica", "1", 2000, 5, "Jung, C. G", "Psicologia");
            livroController.novoLivro("Ruby on Raills", "1", 2013, 4, "Autor Ruby","Programação de software");
            livroController.novoLivro("JavaScript the good parts", "1", 2004, 20, "Autor JS", "Programação de software");
            livroController.novoLivro("Java - Head first", "1", 2007, 10, "Katy Sierra" ,"Programação de software");
            livroController.novoLivro("Escritos", "1", 1950, 10, "Jacques Lacan", "Psicologia");
            livroController.novoLivro("Design Patterns", "1", 2000, 10, "Autor POO", "Programação de software");
            livroController.novoLivro("Principios Solid", "1", 2002, 2,"Autor POO", "Programação de software");            
            livroController.novoLivro("O Fascinante império de Steve Jobs", "1", 2011, 10, "Michael Moritz","Administração Geral");
            livroController.novoLivro("Não Se Iluda, Não", "1", 2015, 5, "Isabela Freitas", "Relações interpessoais");
            livroController.novoLivro("Skyland 1 - Ilhas ao Vento", "1", 2015, 4, "Carlyle , David","Literatura Infantil");
            livroController.novoLivro("O Livro Vermelho", "1", 2013, 20, "Jung, C. G", "Psicologia");
            livroController.novoLivro("O Mal-estar Na Civilização", "1", 2011, 1, "Freud, Sigmund" ,"Psicologia");
            livroController.novoLivro("A Linguagem do Corpo - O que Você Precisa Saber", "1", 2015, 10, "David Cohes", "Psicologia");
            livroController.novoLivro("Programação Com Arduino II - Passos Avançados Com Sketches - Série Tekne", "1", 2015, 10, "Monk, Simon", "Programação de software");
            livroController.novoLivro("Programação - Algoritmos e Estrutura de Dados - 3ª Ed. 2014", "1", 2014, 3,"Pedro Neto, João", "Programação de software");
            
        } catch (Exception ex) {
            Logger.getLogger(UC017.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
    
    @Override
    public void realiza() {
        try {
            System.out.println("\n\n\n");
            System.out.println("Realização caso de uso: UC017 - Consultar Livros ");
            System.out.println("\n");
            
            /** Autentica usuario **/
            System.out.println("Pre-condicao: administrador logado no sistema.");
            Usuario usuarioAutenticado = usuarioController.autentica(login, senha);
            System.out.println("Autenticado com usuario [" + login + "]");
            System.out.println("\n");
            
            System.out.println(Arrays.toString(livroController.buscarLivrosEmprestimoUsuario(usuarioAutenticado).toArray()));
            
            System.out.println("Deseja consultar por nome?");
            String nomeLivro = null;
            if(yesno()){
                nomeLivro = lerEntrada();
            }
            
            System.out.println("Deseja consultar por ano?");
            Integer ano = null;
            if(yesno()){
                ano = lerEntradaInteira();
            }
            
            System.out.println("Deseja consultar por edicao?");
            String edicao = null;
            if(yesno()){
                edicao = lerEntrada();
            }
            
            System.out.println("Deseja consultar por categoria?");
            String categoria = null;
            if(yesno()){
                categoria = lerEntrada();
            }
            
            System.out.println("Deseja consultar por autor?");
            String autor = null;
            if(yesno()){
                autor = lerEntrada();
            }
            
            List<Livro> livros = livroController.consultaLivros(nomeLivro, edicao, ano, categoria, autor);
            validaVisualizacao(livros);
            
            
        } catch (Exception ex) {
            Logger.getLogger(UC017.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void validaVisualizacao(List<Livro> livros){
        if(livros.size() == 1){
            Livro livro = livros.get(0);
            System.out.println("**************************");
            System.out.println("Livro: " + livro.getNome());
            System.out.println("** codigo - " + livro.getCodLivro());
            System.out.println("** edicao - " + livro.getEdicao());
            System.out.println("** ano - " + livro.getAno());
            System.out.println("** autor - " + livro.getAutor().getNome());
            System.out.println("** categoria - " + livro.getCategoria().getDescricao());
            System.out.println("** quantidade estoque - " + livro.quantidade());
            System.out.println("** quantidade disponível - " + livro.quantidadeDisponivel());
            System.out.println("**************************");
        } else {
            livros.stream().forEach((livro) -> {
                System.out.println("Livro [nome=" + livro.getNome() + ", autor=" + livro.getAutor().getNome() +"]");
            });
        }
    }
}
