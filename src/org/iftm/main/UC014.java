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
import org.iftm.poo.controller.AlunoController;
import org.iftm.poo.controller.EmprestimoController;
import org.iftm.poo.controller.LivroController;
import org.iftm.poo.controller.ProfessorController;
import org.iftm.poo.controller.UsuarioController;
import org.iftm.poo.model.domain.Administrador;
import org.iftm.poo.model.domain.Aluno;
import org.iftm.poo.model.domain.Emprestimo;
import org.iftm.poo.model.domain.ItemEmprestimo;
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.Pessoa;
import org.iftm.poo.model.domain.Professor;
import org.iftm.poo.model.domain.TurnoBiblioteca;
import org.iftm.poo.model.domain.Usuario;


/**
 *
 * @author vhmolinar
 */
class UC014 extends UC {
    
    private LivroController livroController;
    private UsuarioController usuarioController;
    private EmprestimoController emprestimoControler;
    private AlunoController alunoController;
    private ProfessorController professorController;
    
    // Credenciais usuario caso de uso
    private Usuario administrador, aluno, professor;
    
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
            administrador = usuarioController.cadastraUsuario("joao.carlos", "123456", pessoa1);
            
            Pessoa aluno1 = alunoController.novoAluno("111", "Aluno 1", "111.111.111-11",new Date() , "Endereço aluno 1", "M");
            aluno = usuarioController.cadastraUsuario("aluno1", "123456", aluno1);
            
            Pessoa prof1 = professorController.novoProfessor(1111, "Professor 1", "222.222.222-22",new Date() , "Endereço professor 1", "M");
            professor = usuarioController.cadastraUsuario("prof1", "123456", prof1);
            
            Livro livro1  = livroController.novoLivro("Java - Head first", "1", 2007, 10, "Katy Sierra" ,"Programação de software");
            emprestimoControler.novoEmprestimo(aluno, livro1);
            
            Livro livro2  = livroController.novoLivro("Java - Introducao", "1", 2000, 10, "Katy Sierra" ,"Programação de software");
            emprestimoControler.novoEmprestimo(professor, livro2);
        
        } catch (Exception ex) {
            Logger.getLogger(UC014.class.getName()).log(Level.SEVERE, null, ex);
        }

        return this;
    }
    
    @Override
    public void realiza() {
        
        
        try {
            System.out.println("\n\n\n");
            System.out.println("Realização caso de uso: UC014 - Consultar Emprestimo ");
            System.out.println("\n");
            
            /** Autentica usuario **/
            System.out.println("Pre-condicao: usuário logado no sistema.\n");
            
            System.out.println("Deseja logar com administrador[digite Y] ou aluno[digite N]?");
            boolean isAdmin = yesno();
            
            
            Usuario usuarioAutenticado;
            if(isAdmin)
                usuarioAutenticado = usuarioController.autentica(administrador.getLogin(), administrador.getSenha());
            else
                usuarioAutenticado = usuarioController.autentica(aluno.getLogin(), aluno.getSenha());
            System.out.println("Autenticado com usuario [" + usuarioAutenticado.getLogin() + "]");
            System.out.println("\n");
            
            List<Emprestimo> emprestimos = emprestimoControler.buscarEmprestimoUsuario(usuarioAutenticado);
            
            for ( Emprestimo e : emprestimos){
                System.out.println(e);
                List<ItemEmprestimo> itens = emprestimoControler.itensEmprestimo(e);
                for ( ItemEmprestimo i : itens)
                    System.out.println(i);
                    
                
            }
        } catch (Exception ex) {
            Logger.getLogger(UC014.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
