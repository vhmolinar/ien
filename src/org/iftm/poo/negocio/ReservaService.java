/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;


import java.util.List;
import org.iftm.poo.model.dao.ItemLivroDao;
import org.iftm.poo.model.dao.ReservaDao;
import org.iftm.poo.model.domain.ItemLivro;
import org.iftm.poo.model.domain.Reserva;
import org.iftm.poo.model.domain.StatusLivro;
import org.iftm.poo.model.domain.TipoPessoa;
import org.iftm.poo.model.domain.Usuario;
import org.iftm.poo.service.DaoFactory;

/**
 *
 * @author Laura
 */
public class ReservaService {
    
    private final ReservaDao reservaDao;
    private final ItemLivroDao itemLivroDao;
    
  
    public ReservaService(){
        reservaDao = DaoFactory.get().resolve(Reserva.class);
        itemLivroDao = DaoFactory.get().resolve(ItemLivro.class);
    }
       
    public Reserva novaReserva(Usuario usuario, ItemLivro itemLivro) throws Exception{
        itemLivro.setStatusLivro(StatusLivro.Reservado);
        itemLivroDao.salvarAtualizar(itemLivro);
        Reserva reserva = new Reserva(usuario, itemLivro);
        reservaDao.salvarAtualizar(reserva);
        return reserva;
    }
    
    public List<Reserva> pesquisarPorExemplo(Reserva reserva) throws Exception{        
        return reservaDao.pesquisar(reserva);
    }
    
    public List<Reserva> pesquisarPorUsuario(Usuario usuario) throws Exception{
        Reserva reserva = new Reserva();
        if(!usuario.getPessoa().tipoPessoa().equals(TipoPessoa.Administrador)){
            reserva.setUsuario(usuario);
           // System.out.println("Não é adm!!");
        }
        return reservaDao.pesquisar(reserva);
    }
    
    public void excluirPorExemplo(Reserva reserva) throws Exception{
        reservaDao.excluir(reserva);
    }
}