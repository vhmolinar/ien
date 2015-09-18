package org.iftm.poo.model.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_livro")
public class ItemLivro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod")
    private Integer codItemLivro;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cod_livro")
    private Livro livro;
    @Enumerated(EnumType.STRING) 
    @Column(name="status")
    private StatusLivro statusLivro;

    public ItemLivro(){
        
    }
    
    public ItemLivro(Livro livro) {
        super();
        this.livro = livro;
    }

    public Integer getCodItemLivro() {
        return codItemLivro;
    }
    public void setCodItemLivro(Integer codItemLivro) {
        this.codItemLivro = codItemLivro;
    }
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public StatusLivro getStatusLivro() {
        return statusLivro;
    }

    public void setStatusLivro(StatusLivro statusLivro) {
        this.statusLivro = statusLivro;
    }

    @Override
    public String toString() {
        return "ItemLivro{" + "codItemLivro=" + codItemLivro + ", livro=" + livro + ", statusLivro=" + statusLivro + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.codItemLivro);
        hash = 41 * hash + Objects.hashCode(this.livro);
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
        final ItemLivro other = (ItemLivro) obj;
        if (!Objects.equals(this.codItemLivro, other.codItemLivro)) {
            return false;
        }
        if (!Objects.equals(this.livro, other.livro)) {
            return false;
        }
        return true;
    }
    
    
}