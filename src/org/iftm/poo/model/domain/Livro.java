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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name="livro" )
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod")
    private Integer codLivro;
    @Column(name="nome",nullable = false)
    private String nome;
    @Column(name="edicao")
    private String edicao;
    @Column(name="ano")
    private Integer ano;
    @OneToMany(mappedBy = "livro", fetch = FetchType.EAGER)
    private List<ItemLivro> itens;
    @ManyToOne
    @JoinColumn(name="cod_categoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name="cod_autor")
    private Autor autor;

    public Livro(){
    }

    public Livro(String nome, String edicao, Integer ano, Categoria categoria, Autor autor) {
        this.nome = nome;
        this.edicao = edicao;
        this.ano = ano;
        this.categoria = categoria;
        this.autor = autor;
    }
    
    public int quantidade() {
        return itens.size();
    }
    
    public int quantidadeDisponivel(){
        int qtde = 0;
        for(ItemLivro itemLivro : itens){
            if(itemLivro.getStatusLivro().equals(StatusLivro.Disponivel)){
                qtde += 1;
            }
        }
        return qtde;
    }
        

    public Integer getCodLivro() {
        return codLivro;
    }
    public void setCodLivro(Integer codLivro) {
        this.codLivro = codLivro;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEdicao() {
        return edicao;
    }
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public List<ItemLivro> getItens() {
        return itens;
    }
    public void setItens(List<ItemLivro> itens) {
        this.itens = itens;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.codLivro);
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.edicao);
        hash = 41 * hash + Objects.hashCode(this.ano);
        hash = 41 * hash + Objects.hashCode(this.categoria);
        hash = 41 * hash + Objects.hashCode(this.autor);
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
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.codLivro, other.codLivro)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.edicao, other.edicao)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return Objects.equals(this.autor, other.autor);
    }

    @Override
    public String toString() {
        return "Livro{" + "codLivro=" + codLivro + ", nome=" + nome + ", edicao=" + edicao + ", ano=" + ano + ", categoria=" + categoria + ", autor=" + autor + '}';
    }
}