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

@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod")
    private Integer codCategoria;
    @Column(name="descricao", nullable = false, unique = true)
    private String descricao;
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Livro> livros;

    public Categoria(){

    }

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodCategoria() {
            return codCategoria;
    }
    public void setCodCategoria(Integer codCategoria) {
            this.codCategoria = codCategoria;
    }
    public String getDescricao() {
            return descricao;
    }
    public void setDescricao(String descricao) {
            this.descricao = descricao;
    }
    public List<Livro> getLivros() {
            return livros;
    }
    public void setLivros(List<Livro> livros) {
            this.livros = livros;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.codCategoria);
        hash = 17 * hash + Objects.hashCode(this.descricao);
        hash = 17 * hash + Objects.hashCode(this.livros);
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.codCategoria, other.codCategoria)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.livros, other.livros)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categoria{" + "codCategoria=" + codCategoria + ", descricao=" + descricao + '}';
    }    
}