package org.iftm.poo.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="emprestimo")
public class Emprestimo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod")
    private Integer codEmprestimo;
    @Column(name="dta_Emprestimo")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmprestimo;
    @Column(name="dta_Devolucao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDevolucao;
    @OneToMany(mappedBy = "emprestimo", fetch = FetchType.LAZY)
    private List<ItemEmprestimo> itens;
    @OneToMany(mappedBy = "emprestimo", fetch = FetchType.LAZY)
    private List<DebitoEmprestimo> debitos;
    @ManyToOne
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;
    
    public Emprestimo(){
		
    }
	
    public Emprestimo(Usuario usuario, List<ItemEmprestimo> itens) {
	super();
	this.dataEmprestimo = new Date();
        this.usuario = usuario;
        this.itens = itens;
        calculaDevolucao();
    }
    
    public final void calculaDevolucao(){
        boolean isAluno = usuario.getPessoa().tipoPessoa().equals(TipoPessoa.Aluno);
        
	Date dFim;
	Calendar dInicio = Calendar.getInstance();
		
	if(isAluno){
            dInicio.add((GregorianCalendar.DAY_OF_MONTH), 15);
            dFim = dInicio.getTime();
	} else {
            dInicio.add((GregorianCalendar.DAY_OF_MONTH), 60);
            dFim = dInicio.getTime();
	}
		
	dataDevolucao = dFim;
    }

    public void adicionaItem(ItemEmprestimo itemEmprestimo){
        if(this.itens == null){
            this.itens = new ArrayList<>();
        }
        this.itens.add(itemEmprestimo);
    }
    
    public void adicionaDebito(DebitoEmprestimo debitoEmprestimo){
        if(this.debitos == null){
            this.debitos = new ArrayList<>();
        }
        this.debitos.add(debitoEmprestimo);
    }    

    public Integer getCodEmprestimo() {
        return codEmprestimo;
    }
    public void setCodEmprestimo(Integer codEmprestimo) {
        this.codEmprestimo = codEmprestimo;
    }
    public List<ItemEmprestimo> getItens() {
        return itens;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setItens(List<ItemEmprestimo> itens) {
        this.itens = itens;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public List<DebitoEmprestimo> getDebitos() {
        return debitos;
    }

    public void setDebitos(List<DebitoEmprestimo> debitos) {
        this.debitos = debitos;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.codEmprestimo);
        hash = 61 * hash + Objects.hashCode(this.dataEmprestimo);
        hash = 61 * hash + Objects.hashCode(this.usuario);
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
        final Emprestimo other = (Emprestimo) obj;
        if (!Objects.equals(this.codEmprestimo, other.codEmprestimo)) {
            return false;
        }
        if (!Objects.equals(this.dataEmprestimo, other.dataEmprestimo)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "codEmprestimo=" + codEmprestimo + 
                ", dataEmprestimo=" + dataEmprestimo + 
                ", dataDevolucao=" + dataDevolucao +
                ", usuario=" + usuario + '}';
    }
}