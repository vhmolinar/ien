package org.iftm.poo.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.JOINED;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="pessoa")
@Inheritance(strategy=JOINED)
@DiscriminatorColumn(name="tipo_pessoa",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("generico")
public abstract class Pessoa implements Serializable {
    @Id
    @Column(name="cod")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPessoa;
    @Column(name="nome", nullable = false)
    private String nome;
    @Column(name="cpf", nullable = false, unique = true)
    private String cpf;
    @Column(name="nascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;
    @Column(name="endereco")
    private String endereco;
    @Column(name="genero")
    private String genero;

    public Pessoa(){
    }
    
    public Pessoa(String nome, String cpf){
        super();
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public Pessoa(String nome, String cpf, Date nascimento, String endereco,
                    String genero) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.genero = genero;
    }


    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Date getNascimento() {
        return nascimento;
    }
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", nascimento="
                        + nascimento + ", endereco=" + endereco + ", genero=" + genero
                        + "]";
    }

    public Integer getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Integer codPessoa) {
        this.codPessoa = codPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.codPessoa);
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.cpf);
        hash = 71 * hash + Objects.hashCode(this.nascimento);
        hash = 71 * hash + Objects.hashCode(this.endereco);
        hash = 71 * hash + Objects.hashCode(this.genero);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.codPessoa, other.codPessoa)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return Objects.equals(this.genero, other.genero);
    }

    public TipoPessoa tipoPessoa() {
        if(this instanceof Aluno){
            return TipoPessoa.Aluno;
        }else if(this instanceof Administrador){
            return TipoPessoa.Administrador;
        } else {
            return TipoPessoa.Professor;
        }
    }
    
}