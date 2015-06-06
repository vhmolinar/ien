/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author vhmolinar
 */
@Entity
@Table(name="professor")
@DiscriminatorValue("professor")
public class Professor extends Pessoa implements Serializable {
    @Column(name="matricula")
    private Integer matricula;

    public Professor() {
    }

    public Professor(Integer matricula) {
        this.matricula = matricula;
    }

    public Professor(Integer matricula, String nome, String cpf, Date nascimento, String endereco, String genero) {
        super(nome, cpf, nascimento, endereco, genero);
        this.matricula = matricula;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.matricula);
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
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Professor{" + "matricula=" + matricula + '}';
    }    
}
