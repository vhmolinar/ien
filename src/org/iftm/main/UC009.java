package org.iftm.main;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.iftm.poo.controller.AlunoController;
import org.iftm.poo.controller.EmprestimoController;
import org.iftm.poo.controller.LivroController;
import org.iftm.poo.controller.ProfessorController;
import org.iftm.poo.controller.ReservaController;
import org.iftm.poo.controller.UsuarioController;
import org.iftm.poo.model.domain.Administrador;
import org.iftm.poo.model.domain.Emprestimo;
import org.iftm.poo.model.domain.ItemEmprestimo;
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.Pessoa;
import org.iftm.poo.model.domain.Reserva;
import org.iftm.poo.model.domain.TurnoBiblioteca;
import org.iftm.poo.model.domain.Usuario;
// Credenciais usuario caso de uso
/** Cria um usuario base e pega as credenciais**/
/** Autentica usuario **/
public class UC009 extends UC{
    
    private LivroController livroController;
    private UsuarioController usuarioController;
    private EmprestimoController emprestimoControler;
    private AlunoController alunoController;
    private ProfessorController professorController;
    private ReservaController reservaController;
    
    // Credenciais usuario caso de uso
    private Usuario administrador, aluno, professor, usuario;	

    @Override
    public UC preparaBase() {
        livroController = new LivroController();
        usuarioController = new UsuarioController();
        emprestimoControler = new EmprestimoController();
        alunoController = new AlunoController();
        professorController = new ProfessorController();
        reservaController = new ReservaController();
        
        
        try {
            /** Cria um usuario base e pega as credenciais**/
            Pessoa pessoa1 = new Administrador(TurnoBiblioteca.Tarde, "João Carlos", "200.123.405-95");
            administrador = usuarioController.cadastraUsuario("joao.carlos", "123456", pessoa1);
            
            Pessoa aluno4 = alunoController.novoAluno("444", "Aluno 4", "444.444.444-44",new Date() , "Endereço aluno 4", "M");
            aluno = usuarioController.cadastraUsuario("aluno4", "123456", aluno4);
            
           
            Pessoa prof5 = professorController.novoProfessor(5555, "Professor 5", "555.555.555-55",new Date() , "Endereço professor 5", "M");
            professor = usuarioController.cadastraUsuario("prof5", "123456", prof5);
            
            Livro livro1  = livroController.novoLivro("Java - Head first", "1", 2007, 10, "Katy Sierra" ,"Programação de software");
            emprestimoControler.novoEmprestimo(aluno, livro1);
            
            Livro livro2  = livroController.novoLivro("Java - Introducao", "1", 2000, 10, "Katy Sierra" ,"Programação de software");
            emprestimoControler.novoEmprestimo(professor, livro2);
            
            Reserva reserva1 = reservaController.novaReserva(aluno, livro1);
            Reserva reserva2 = reservaController.novaReserva(aluno, livro2);
            Reserva reserva3 = reservaController.novaReserva(professor, livro1);
            
        } catch (Exception ex) {
            Logger.getLogger(UC014.class.getName()).log(Level.SEVERE, null, ex);
        }

        return this;
    
    }
	
	public void realiza() {
            try {
            System.out.println("\n\n\n");
            System.out.println("Realização caso de uso: UC009 - Realizar Emprestimo ");
            System.out.println("\n");
            
            /** Autentica usuario **/
            System.out.println("Pre-condicao: Administrador logado no sistema.");
            Usuario usuarioAutenticado;
            usuarioAutenticado = usuarioController.autentica(administrador.getLogin(), administrador.getSenha());
            System.out.println("Autenticado com usuario [" + usuarioAutenticado.getLogin() + "]");
            System.out.println("\n");
            
            System.out.println("Os usuários cadastrados são:\n");      
            
            List<Usuario> listaUsuarios = usuarioController.buscarTodosUsuarios();
            for ( Usuario u : listaUsuarios){
                System.out.println(u);
            }
            
            Integer codUsuario = null;
            System.out.println("\n\nDigite o códoigo do usuário (aluno/professor) que deseja realizar o empréstimo.\n");
            if(yesno()){
                codUsuario = lerEntradaInteira();
            }
            List<Usuario> usuarios = usuarioController.pesquisarPorExemplo(codUsuario);
            
            if(usuarios.size() == 0){
                System.out.println("Usuário não encontrado!");
            }
            else{
                usuario = usuarios.get(0);
                System.out.println("\nDeseja fazer empréstimo com reserva[digite Y] ou sem reserva[digite N]?");
                boolean comReserva = yesno();

                Emprestimo e = null;
                Reserva reserva = null;
                Livro livro = null;
                if(comReserva){
                    System.out.println("\nAs reservas do usuário " + usuario.getLogin() + " são:\n"); 
                    
                    List<Reserva> reservasUsuario = reservaController.buscarReservaUsuario(usuario);
                    for ( Reserva r : reservasUsuario){
                        System.out.println(r);
                    }
                    
                    Integer codReserva = null;
                    System.out.println("\n\nDigite o códoigo do reserva que vai efetivar o empréstimo:\n");
                    if(yesno()){
                        codReserva = lerEntradaInteira();
                    }
                    
                    List<Reserva> reservas = reservaController.pesquisarPorExemplo(codReserva);
                    if (reservas.size() == 0){
                        System.out.println("Reserva não encontrada!!\n");
                    }
                    else{
                        reserva = reservas.get(0);
                        e = emprestimoControler.novoEmprestimoComReserva(usuario, reserva);
                    }
                }
                else{
                    System.out.println("Os livros cadastrados são:\n");      

                    List<Livro> livrosCadastrados = livroController.buscarTodosLivros();
                    for ( Livro l : livrosCadastrados){
                        System.out.println(l);
                    }

                    Integer codLivro = null;
                    System.out.println("\n\nDigite o códoigo do livro que o (aluno/professor) deseja:\n");
                    if(yesno()){
                        codLivro = lerEntradaInteira();
                    }

                    List<Livro> livros = livroController.pesquisarPorExemplo(codLivro);
                    
                    if(livros.size() == 0){
                        System.out.println("Livro não encontrado!!");
                    }else{
                        livro = livros.get(0);
                        e = emprestimoControler.novoEmprestimo(usuario, livro);
                    }
                }

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