/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.main;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.iftm.poo.controller.AlunoController;
import org.iftm.poo.controller.EmprestimoController;
import org.iftm.poo.controller.LivroController;
import org.iftm.poo.controller.ProfessorController;
import org.iftm.poo.controller.UsuarioController;
import org.iftm.poo.model.domain.Administrador;
import org.iftm.poo.model.domain.Emprestimo;
import org.iftm.poo.model.domain.ItemEmprestimo;
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.Pessoa;
import org.iftm.poo.model.domain.TurnoBiblioteca;
import org.iftm.poo.model.domain.Usuario;

/**
 *
 * @author wisneycardeal
 */
class UC012 extends UC {

	private LivroController livroController;
	private UsuarioController usuarioController;
	private EmprestimoController emprestimoController;
	private AlunoController alunoController;
	private ProfessorController professorController;

	// Credenciais usuario caso de uso
	private String login, senha;

	public UC012() {
	}

	@Override
	public UC preparaBase() {
		usuarioController = new UsuarioController();
		livroController = new LivroController();
		emprestimoController = new EmprestimoController();
		alunoController = new AlunoController();
		professorController = new ProfessorController();

		try {
			/** Cria livros base para realizacao do caso de uso **/
			Livro livro1 = livroController.novoLivro("POO", "1", 2015, 10, "Autor POO", "Programação de software");
			Livro livro2 = livroController.novoLivro("Psicologia Analítica", "1", 2000, 5, "Jung, C. G", "Psicologia");
			Livro livro3 = livroController.novoLivro("Ruby on Raills", "1", 2013, 4, "Autor Ruby",
					"Programação de software");
			Livro livro4 = livroController.novoLivro("JavaScript the good parts", "1", 2004, 20, "Autor JS",
					"Programação de software");
			Livro livro5 = livroController.novoLivro("Java - Head first", "1", 2007, 10, "Katy Sierra",
					"Programação de software");
			livroController.novoLivro("Escritos", "1", 1950, 10, "Jacques Lacan", "Psicologia");
			livroController.novoLivro("Design Patterns", "1", 2000, 10, "Autor POO", "Programação de software");
			livroController.novoLivro("Principios Solid", "1", 2002, 2, "Autor POO", "Programação de software");
			livroController.novoLivro("O Fascinante império de Steve Jobs", "1", 2011, 10, "Michael Moritz",
					"Administração Geral");
			livroController.novoLivro("Não Se Iluda, Não", "1", 2015, 5, "Isabela Freitas", "Relações interpessoais");
			livroController.novoLivro("Skyland 1 - Ilhas ao Vento", "1", 2015, 4, "Carlyle , David",
					"Literatura Infantil");
			livroController.novoLivro("O Livro Vermelho", "1", 2013, 20, "Jung, C. G", "Psicologia");
			livroController.novoLivro("O Mal-estar Na Civilização", "1", 2011, 1, "Freud, Sigmund", "Psicologia");
			livroController.novoLivro("A Linguagem do Corpo - O que Você Precisa Saber", "1", 2015, 10, "David Cohes",
					"Psicologia");
			livroController.novoLivro("Programação Com Arduino II - Passos Avançados Com Sketches - Série Tekne", "1",
					2015, 10, "Monk, Simon", "Programação de software");
			livroController.novoLivro("Programação - Algoritmos e Estrutura de Dados - 3ª Ed. 2014", "1", 2014, 3,
					"Pedro Neto, João", "Programação de software");

			/** Cria um usuario base e pega as credenciais **/
			Pessoa pessoa = new Administrador(TurnoBiblioteca.Tarde, "João Carlos", "200.123.405-95");
			Usuario administrador = usuarioController.cadastraUsuario("joao.carlos", "123456", pessoa);
			login = administrador.getLogin();
			senha = administrador.getSenha();

			Pessoa aluno1 = alunoController.novoAluno("111", "Aluno 1", "111.111.111-11", new Date(),
					"Endereço aluno 1", "M");
			Usuario aluno = usuarioController.cadastraUsuario("aluno1", "123456", aluno1);

			Pessoa prof1 = professorController.novoProfessor(2222, "Professor 1", "222.222.222-22", new Date(),
					"Endereço professor 1", "M");
			Usuario professor = usuarioController.cadastraUsuario("prof1", "123456", prof1);

			emprestimoController.novoEmprestimo(aluno, livro1);
			emprestimoController.novoEmprestimo(aluno, livro2);
			emprestimoController.novoEmprestimo(aluno, livro3);
			emprestimoController.novoEmprestimo(professor, livro4);
			emprestimoController.novoEmprestimo(professor, livro5);

		} catch (Exception ex) {
			Logger.getLogger(UC017.class.getName()).log(Level.SEVERE, null, ex);
		}
		return this;
	}

	@Override
	public void realiza() {
		try {
			Boolean renovar = true;
			while(renovar){
				System.out.println("\n\n\n");
				System.out.println("Realização caso de uso: UC012 - Renovar Empréstimo ");
				System.out.println("\n");
	
				/** Autentica usuario **/
				System.out.println("Pre-condicao: administrador logado no sistema.");
				Usuario usuarioAutenticado = usuarioController.autentica(login, senha);
				System.out.println("Autenticado com usuario [" + login + "]");
				System.out.println("\n\n");
	
				System.out.println("Usuários cadastrados:\n");
	
				List<Usuario> listaUsuarios = usuarioController.buscarTodosUsuarios();
				for (Usuario u : listaUsuarios) {
					System.out.println(u);
				}
	
				System.out.println("\n\nInforme o código do aluno/professor que deseja renovar o empréstimo: ");
				final Integer codUsuario = this.lerEntradaInteira();
				List<Usuario> usuarios = usuarioController.pesquisarPorExemplo(codUsuario);
	
				if (usuarios.size() == 0) {
					System.out.println("Aluno/Professor não encontrado!");
				} else {
					Usuario user = usuarios.stream().filter(u -> u.getCodUsuario().equals(codUsuario)).findFirst().get();
					List<Emprestimo> emprestimos = emprestimoController.buscarEmprestimoUsuario(user);
	
					for (Emprestimo e : emprestimos) {
						if (e.getUsuario().getCodUsuario().equals(user.getCodUsuario())) {
							System.out.println(e);
							List<ItemEmprestimo> itens = emprestimoController.itensEmprestimo(e);
							for (ItemEmprestimo i : itens)
								System.out.println(i);
						}
					}
				
					System.out.println("\n\nInforme o código do empréstimo que deseja renovar: ");
					final Integer codEmprestimo = this.lerEntradaInteira();
					Emprestimo emp = emprestimos.stream().filter(e -> e.getCodEmprestimo().equals(codEmprestimo)).findFirst().get();
					List<ItemEmprestimo> itens = emprestimoController.itensEmprestimo(emp);
					Boolean livroReservado = false;
					for(ItemEmprestimo i : itens) {
						livroReservado = (i.getItemLivro().getLivro().quantidadeDisponivel() <= 0);
					}
					
					if(livroReservado){
						System.out.println("\n\nO livro relacionado possui outras reservas. Selecione outra opção:\n");
						renovar = false;
						UC.apresentaCasosDeUso().preparaCasoDeUso().realiza();
					} else {
						emp.calculaDevolucao();
						System.out.println("\n\nEmpréstimo a ser renovado:\n");
						System.out.println(emp.toString());
						for (ItemEmprestimo i : itens)
							System.out.println(i);
						System.out.println("\n\nConfirma a renovação do emprestimo? "  );
						if(yesno()){
							for(ItemEmprestimo i : itens) {
								Emprestimo e = emprestimoController.novoEmprestimo(user, i.getItemLivro().getLivro());
								List<ItemEmprestimo> itensNovo = emprestimoController.itensEmprestimo(e);
								System.out.println("\n\nEmpréstimo renovado:\n");
								System.out.println(e.toString());
								for (ItemEmprestimo ii : itensNovo)
									System.out.println(ii);
							}
							renovar = false;
						}
					}
				}
				
				this.lerEntrada();
			}

		} catch (Exception ex) {
			Logger.getLogger(UC012.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
