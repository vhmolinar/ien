/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.main;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.iftm.poo.controller.AlunoController;
import org.iftm.poo.controller.EmprestimoController;
import org.iftm.poo.controller.LivroController;
import org.iftm.poo.controller.ProfessorController;
import org.iftm.poo.controller.UsuarioController;
import org.iftm.poo.model.domain.Administrador;
import org.iftm.poo.model.domain.Emprestimo;
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.Pessoa;
import org.iftm.poo.model.domain.TurnoBiblioteca;
import org.iftm.poo.model.domain.Usuario;

/**
 *
 * @author vhmolinar
 */
class UC018 extends UC {
    
    private LivroController livroController;
    private UsuarioController usuarioController;
    private EmprestimoController emprestimoControler;
    private AlunoController alunoController;
    private ProfessorController professorController;

    private String login, senha;
    
    public UC018() {
    }

    @Override
    public UC preparaBase() {
        
        livroController = new LivroController();
        usuarioController = new UsuarioController();
        emprestimoControler = new EmprestimoController();
        alunoController = new AlunoController();
        professorController = new ProfessorController();
        
        
        try {
            /** Cria um usuario base e pega as credenciais**/
            Pessoa pessoa1 = new Administrador(TurnoBiblioteca.Tarde, "João Carlos", "200.123.405-95");
            Usuario administrador = usuarioController.cadastraUsuario("joao.carlos", "123456", pessoa1);
            login = administrador.getLogin();
            senha = administrador.getSenha();
            
            Livro livro1 = livroController.novoLivro("POO", "1", 2015, 10, "Autor POO","Programação de software");
            Livro livro2 = livroController.novoLivro("Psicologia Analítica", "1", 2000, 5, "Jung, C. G", "Psicologia");
            Livro livro3 = livroController.novoLivro("Ruby on Raills", "1", 2013, 4, "Autor Ruby","Programação de software");
            Livro livro4 = livroController.novoLivro("JavaScript the good parts", "1", 2004, 20, "Autor JS", "Programação de software");
            Livro livro5 = livroController.novoLivro("Java - Head first", "1", 2007, 10, "Katy Sierra" ,"Programação de software");
            Livro livro6 = livroController.novoLivro("Escritos", "1", 1950, 10, "Jacques Lacan", "Psicologia");
            Livro livro7 = livroController.novoLivro("Design Patterns", "1", 2000, 10, "Autor POO", "Programação de software");
            Livro livro8 = livroController.novoLivro("Principios Solid", "1", 2002, 2,"Autor POO", "Programação de software");            
            livroController.novoLivro("O Fascinante império de Steve Jobs", "1", 2011, 10, "Michael Moritz","Administração Geral");
            livroController.novoLivro("Não Se Iluda, Não", "1", 2015, 5, "Isabela Freitas", "Relações interpessoais");
            livroController.novoLivro("Skyland 1 - Ilhas ao Vento", "1", 2015, 4, "Carlyle , David","Literatura Infantil");
            livroController.novoLivro("O Livro Vermelho", "1", 2013, 20, "Jung, C. G", "Psicologia");
            livroController.novoLivro("O Mal-estar Na Civilização", "1", 2011, 1, "Freud, Sigmund" ,"Psicologia");
            livroController.novoLivro("A Linguagem do Corpo - O que Você Precisa Saber", "1", 2015, 10, "David Cohes", "Psicologia");
            livroController.novoLivro("Programação Com Arduino II - Passos Avançados Com Sketches - Série Tekne", "1", 2015, 10, "Monk, Simon", "Programação de software");
            livroController.novoLivro("Programação - Algoritmos e Estrutura de Dados - 3ª Ed. 2014", "1", 2014, 3,"Pedro Neto, João", "Programação de software");
            
            Pessoa aluno1 = alunoController.novoAluno("111", "Lucas Souza", "111.111.111-11",new Date() , "Endereço aluno 1", "M");
            Usuario aluno = usuarioController.cadastraUsuario("aluno1", "123456", aluno1);
            
            Pessoa prof1 = professorController.novoProfessor(1111, "Vinicios Diniz", "222.222.222-21",new Date() , "Endereço professor 1", "M");
            Pessoa prof2 = professorController.novoProfessor(1112, "Marcos Albuquerque", "222.222.222-22",new Date() , "Endereço professor 2", "M");
            Pessoa prof3 = professorController.novoProfessor(1113, "Maria João", "222.222.222-23",new Date() , "Endereço professor 3", "F");
            Pessoa prof4 = professorController.novoProfessor(1114, "Beatriz Salgado", "222.222.222-24",new Date() , "Endereço professor 4", "F");
            Usuario u1 = usuarioController.cadastraUsuario("vinicios.diniz", "123456", prof1);
            Usuario u2 = usuarioController.cadastraUsuario("marcos.albuquerque", "123456", prof2);
            Usuario u3 = usuarioController.cadastraUsuario("maria.joao", "123456", prof3);
            Usuario u4 = usuarioController.cadastraUsuario("beatriz.salgado", "123456", prof4);
            
            Emprestimo emprestimo1 = emprestimoControler.novoEmprestimo(aluno, livro1);
            Emprestimo emprestimo2 = emprestimoControler.novoEmprestimo(u1, livro2);
            Emprestimo emprestimo3 = emprestimoControler.novoEmprestimo(aluno, livro3);
            Emprestimo emprestimo4 = emprestimoControler.novoEmprestimo(u2, livro4);
            Emprestimo emprestimo5 = emprestimoControler.novoEmprestimo(aluno, livro5);
            Emprestimo emprestimo6 = emprestimoControler.novoEmprestimo(u3, livro6);
            Emprestimo emprestimo7 = emprestimoControler.novoEmprestimo(aluno, livro7);
            Emprestimo emprestimo8 = emprestimoControler.novoEmprestimo(u4, livro8);
            
            Calendar dtEmprestimo = Calendar.getInstance(), dtDevolucao = Calendar.getInstance();
            dtEmprestimo.add(Calendar.MONTH, -2);
            dtDevolucao.add(Calendar.MONTH, -1);
            
            for(Emprestimo emprestimo : Arrays.asList(emprestimo1, emprestimo2, emprestimo3, emprestimo4)){
                emprestimo.setDataEmprestimo(dtEmprestimo.getTime());
                emprestimo.setDataDevolucao(dtDevolucao.getTime());
                emprestimoControler.atualizar(emprestimo);
            }
            
            
        
        } catch (Exception ex) {
            Logger.getLogger(UC014.class.getName()).log(Level.SEVERE, null, ex);
        }

        return this;
    }
    
    @Override
    public void realiza() {        
        try {
            System.out.println("\n\n\n");
            System.out.println("Realização caso de uso: UC018 - Gerenciar Empréstimos ");
            System.out.println("\n");
            
            /** Autentica usuario **/
            System.out.println("Pre-condicao: administrador logado no sistema.");
            Usuario usuarioAutenticado = usuarioController.autentica(login, senha);
            System.out.println("Autenticado com usuario [" + login + "]");
            System.out.println("\n");
            
            System.out.println("Deseja filtrar pelos empréstimos vencidos?");
            boolean filtrar = yesno();
            
            List<Emprestimo> emprestimos = emprestimoControler.listaEmprestimos();
            if(filtrar){
                Collections.sort(emprestimos, new Comparator<Emprestimo>(){
                    @Override
                    public int compare(Emprestimo o1, Emprestimo o2) {
                        return Long.compare(o1.getDataDevolucao().getTime(), o2.getDataDevolucao().getTime());
                    }
                });
            }
            
            emprestimos.stream().forEach((emprestimo) -> {
                StringBuilder sb = new StringBuilder("Emprestimo[" + emprestimo.getCodEmprestimo() + "] ");
                sb.append(" - ");
                sb.append(" [usuário do tipo " + emprestimo.getUsuario().getPessoa().tipoPessoa() + " => " + emprestimo.getUsuario().getPessoa().getNome() + "] ");
                sb.append(" [data emprestimo " + emprestimo.getDataEmprestimo() + "]");
                sb.append(" [data devolução " + emprestimo.getDataDevolucao() + "]");
                System.out.println(sb.toString());
            });
        } catch (Exception ex) {
            Logger.getLogger(UC018.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
