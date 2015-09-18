package org.iftm.poo.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
@Entity
@Table(name="debito_emprestimo")
public class DebitoEmprestimo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod")
    private Integer codDebito;
    @Column(name="data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @Column(name="taxa")
    private BigDecimal taxa;
    @ManyToOne
    @JoinColumn(name="cod_emprestimo")
    private Emprestimo emprestimo;

    public DebitoEmprestimo(){

    }

    public DebitoEmprestimo(Date data, BigDecimal taxa, Emprestimo emprestimo) {
        this.data = data;
        this.taxa = taxa;
        this.emprestimo = emprestimo;
    }

    public Integer getCodDebito() {
        return codDebito;
    }
    public void setCodDebito(Integer codDebito) {
        this.codDebito = codDebito;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }
    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
        this.emprestimo.adicionaDebito(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codDebito);
        hash = 79 * hash + Objects.hashCode(this.data);
        hash = 79 * hash + Objects.hashCode(this.taxa);
        hash = 79 * hash + Objects.hashCode(this.emprestimo);
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
        final DebitoEmprestimo other = (DebitoEmprestimo) obj;
        if (!Objects.equals(this.codDebito, other.codDebito)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.taxa, other.taxa)) {
            return false;
        }
        return Objects.equals(this.emprestimo, other.emprestimo);
    }

    @Override
    public String toString() {
        return "DebitoEmprestimo{" + "codDebito=" + codDebito + ", data=" + data + ", taxa=" + taxa + ", emprestimo=" + emprestimo + '}';
    }
    
    
}