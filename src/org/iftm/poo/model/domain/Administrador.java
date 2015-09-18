package org.iftm.poo.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
@DiscriminatorValue("administrador")
public class Administrador extends Pessoa implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING) 
    @Column(name="turno")
    private TurnoBiblioteca turno;
    
    public Administrador(){
    }

    public Administrador(TurnoBiblioteca turno) {
        this.turno = turno;
    }

    public Administrador(TurnoBiblioteca turno, String nome, String cpf) {
        super(nome, cpf);
        this.turno = turno;
    }

    public Administrador(TurnoBiblioteca turno, String nome, String cpf, Date nascimento, String endereco, String genero) {
        super(nome, cpf, nascimento, endereco, genero);
        this.turno = turno;
    }

    public TurnoBiblioteca getTurno() {
        return turno;
    }

    public void setTurno(TurnoBiblioteca turno) {
        this.turno = turno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.turno);
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
        final Administrador other = (Administrador) obj;
        return this.turno == other.turno;
    }

    @Override
    public String toString() {
        return "Administrador{" + "turno=" + turno + '}';
    }
}