package org.iftm.poo.model.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_emprestimo")
public class ItemEmprestimo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod")
    private Integer codItemEmprestimo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cod_item_livro")
    private ItemLivro itemLivro;
    @ManyToOne
    @JoinColumn(name="cod_emprestimo")
    private Emprestimo emprestimo;

    public ItemEmprestimo(){

    }

    public ItemEmprestimo(ItemLivro itemLivro) {
        this.itemLivro = itemLivro;
    }

    public Integer getCodItemEmprestimo() {
        return codItemEmprestimo;
    }
    public void setCodItemEmprestimo(Integer codItemEmprestimo) {
        this.codItemEmprestimo = codItemEmprestimo;
    }
    public ItemLivro getItemLivro() {
        return itemLivro;
    }
    public void setItemLivro(ItemLivro itemLivro) {
        this.itemLivro = itemLivro;
    }
    public Emprestimo getEmprestimo() {
        return emprestimo;
    }
    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    @Override
    public String toString() {
        return "ItemEmprestimo [codItemEmprestimo=" + codItemEmprestimo
                 + ", itemLivro=" + itemLivro + "]";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.codItemEmprestimo);
        hash = 29 * hash + Objects.hashCode(this.itemLivro);
        hash = 29 * hash + Objects.hashCode(this.emprestimo);
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
        final ItemEmprestimo other = (ItemEmprestimo) obj;
        if (!Objects.equals(this.codItemEmprestimo, other.codItemEmprestimo)) {
            return false;
        }
        if (!Objects.equals(this.itemLivro, other.itemLivro)) {
            return false;
        }
        if (!Objects.equals(this.emprestimo, other.emprestimo)) {
            return false;
        }
        return true;
    }
    
    
}