/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import javax.persistence.EntityManager;
import org.iftm.poo.model.domain.Reserva;

/**
 *
 * @author Laura
 */
public class ReservaDao extends TemplateDao<Reserva>{
    
    public ReservaDao(){
        this.tipoEntidade = Reserva.class;
    }

    @Override
    protected Reserva salvarAtualizarImpl(EntityManager em, Reserva reserva) throws Exception {
        if(reserva.getCodReserva() != null){
            reserva = em.merge(reserva);
        }
        em.persist(reserva);
        return reserva;
    }
    
}