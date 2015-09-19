/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author vhmolinar
 */
@Table
@Entity(name = "autor")
public class Autor implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "cod")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codAutor;
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;
    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
    private List<Livro> livros;

    public Autor() {
    }

    public Autor(String nome) {
        this.nome = nome;
    }

    public Integer getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(Integer codAutor) {
        this.codAutor = codAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.codAutor);
        hash = 37 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.codAutor, other.codAutor)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Autor{" + "codAutor=" + codAutor + ", nome=" + nome + '}';
    }
}
