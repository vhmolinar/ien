package org.iftm.poo.boundary;

import java.io.Serializable;

import org.iftm.poo.model.domain.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String nome;
	private String edicao;
	private Integer ano;
	private Integer qtde;
	
	private Integer codAutor;
	private String nomeAutor;

	private Integer codCategoria;
	private String nomeCategoria;
	
	public LivroDTO(){
		
	}
	
	public LivroDTO(Integer codigo, String nome, String edicao, Integer ano, Integer qtde, Integer codAutor, Integer codCategoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.edicao = edicao;
		this.ano = ano;
		this.qtde = qtde;
		this.codAutor = codAutor;
		this.codCategoria = codCategoria;
	}
	
	public LivroDTO(String nome, String edicao, Integer ano, Integer qtde, Integer codAutor, Integer codCategoria) {
		super();
		this.nome = nome;
		this.edicao = edicao;
		this.ano = ano;
		this.qtde = qtde;
		this.codAutor = codAutor;
		this.codCategoria = codCategoria;
	}	


	public LivroDTO(Livro livro){
		this.codigo = livro.getCodLivro();
		this.nome = livro.getNome();
		this.edicao = livro.getEdicao();
		this.ano = livro.getAno();
		this.qtde = 1;
		
		this.codAutor = livro.getAutor() != null ?  livro.getAutor().getCodAutor() : null;
		this.nomeAutor = livro.getAutor() != null ?  livro.getAutor().getNome() : null;
		
		this.codCategoria = livro.getCategoria() != null ? livro.getCategoria().getCodCategoria() : null;
		this.nomeCategoria = livro.getCategoria() != null ? livro.getCategoria().getDescricao() : null;
	}	
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Integer getCodAutor() {
		return codAutor;
	}

	public void setCodAutor(Integer codAutor) {
		this.codAutor = codAutor;
	}

	public Integer getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(Integer codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

}
