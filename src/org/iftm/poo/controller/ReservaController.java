/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.controller;

import java.util.Arrays;
import java.util.List;
import org.iftm.poo.model.domain.ItemLivro;
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.Reserva;
import org.iftm.poo.model.domain.StatusLivro;
import org.iftm.poo.model.domain.Usuario;
import org.iftm.poo.negocio.ReservaService;

/**
 *
 * @author Laura
 */
public class ReservaController {
    
    private final ReservaService reservaService;
    
    public ReservaController(){
        reservaService = new ReservaService();
    }
    
    public Reserva novaReserva(Usuario usuario, Livro livro) throws Exception {
        
        ItemLivro iLiv = null;
        for(ItemLivro itemLivro : livro.getItens()){
            if(itemLivro.getStatusLivro().equals(StatusLivro.Disponivel)){
                iLiv = itemLivro;
                break;
            }
        }
        
        if(iLiv == null){
            throw new Exception("Livro indisponivel para reserva!");
        }
        
        return reservaService.novaReserva(usuario, iLiv);
    }
  
     public List<Reserva> buscarReservaUsuario(Usuario usuario) throws Exception{
        return reservaService.pesquisarPorUsuario(usuario);
    }
     
    public List<Reserva> pesquisarPorExemplo(Integer codReserva) throws Exception{        
        Reserva reserva = new Reserva();
        reserva.setCodReserva(codReserva);
        return reservaService.pesquisarPorExemplo(reserva);
    }
}