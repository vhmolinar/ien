/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.iftm.poo.model.domain.Emprestimo;
import org.iftm.poo.model.domain.ItemEmprestimo;
import org.iftm.poo.model.domain.ItemLivro;
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.Reserva;
import org.iftm.poo.model.domain.StatusLivro;
import org.iftm.poo.model.domain.Usuario;
import org.iftm.poo.negocio.EmprestimoService;
import org.iftm.poo.negocio.LivroService;
import org.iftm.poo.negocio.UsuarioService;

/**
 *
 * @author vhmolinar
 */
public class EmprestimoController {
    
    private final EmprestimoService emprestimoService;
    private final UsuarioService usuarioService;
    private final LivroService livroService;
    
    public EmprestimoController(){
        emprestimoService = new EmprestimoService();
        usuarioService = new UsuarioService();
        livroService = new LivroService();
    }
    
    public Emprestimo novoEmprestimo(Usuario usuario, Livro livro) throws Exception {
        
        ItemLivro iLiv = null;
        for(ItemLivro itemLivro : livro.getItens()){
            if(itemLivro.getStatusLivro().equals(StatusLivro.Disponivel)){
                iLiv = itemLivro;
                break;
            }
        }
        
        if(iLiv == null){
            throw new Exception("Livro indisponivel para emprestimo!");
        }
        
        return emprestimoService.novoEmprestimo(usuario, Arrays.asList(iLiv));
    }
    
    public Emprestimo novoEmprestimoComReserva(Usuario usuario, Reserva reserva) throws Exception {
        
        ItemLivro iLiv = reserva.getItemLivro();
        iLiv.setStatusLivro(StatusLivro.Emprestado);
               
        return emprestimoService.novoEmprestimo(usuario, Arrays.asList(iLiv));
    }
  
     public List<Emprestimo> buscarEmprestimoUsuario(Usuario usuario) throws Exception{
        return emprestimoService.pesquisarPorUsuario(usuario);
    }
     
     public List<ItemEmprestimo> itensEmprestimo(Emprestimo emprestimo)throws Exception{
         return emprestimoService.itensEmprestimo(emprestimo);
     }
     
     public List<Emprestimo> listaEmprestimos() throws Exception{
         Emprestimo emprestimo = new Emprestimo();
         return emprestimoService.pesquisarPorExemplo(emprestimo);
     }
     
     public Emprestimo atualizar(Emprestimo emprestimo) throws Exception{
         return emprestimoService.atualizar(emprestimo);
     }
}
