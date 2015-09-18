package org.iftm.poo.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="aluno")
@DiscriminatorValue("aluno")
public class Aluno extends Pessoa implements Serializable {
    
    @Column(name="matricula")
    private String matricula;

    public Aluno(){

    }

    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public Aluno(String matricula, String nome, String cpf, Date nascimento, String endereco, String genero) {
        super(nome, cpf, nascimento, endereco, genero);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.matricula);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + '}';
    }    
}