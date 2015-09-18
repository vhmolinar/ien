/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author vhmolinar
 */
@Entity
@Table(name="reserva")
public class Reserva implements Serializable {
    
    @Column(name="cod")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codReserva;
    @ManyToOne
    @JoinColumn(name="cod_item_livro")
    private ItemLivro itemLivro;
    @ManyToOne
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;
    
    public Reserva(){

    }
    
    public Reserva(Usuario usuario, ItemLivro itemLivro) {
	super();
	this.usuario = usuario;
        this.itemLivro = itemLivro;
    }
    
    public Integer getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(Integer codReserva) {
        this.codReserva = codReserva;
    }

    public ItemLivro getItemLivro() {
        return itemLivro;
    }

    public void setItemLivro(ItemLivro itemLivro) {
        this.itemLivro = itemLivro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public String toString() {
        return "Reserva{" + "codReserva=" + codReserva + 
                ", itemLivro=" + itemLivro + ", usuario=" + usuario + '}';
    }
    
    
}
