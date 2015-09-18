package org.iftm.poo.boundary;

import org.iftm.poo.model.domain.Livro;

public class LivroDTO {
	
	private Integer codigo;
	private String nome;
	private String edicao;
	private Integer ano;
	private Integer qtde;
	private String autor;
	private String categoria;
	
	public LivroDTO(Livro livro){
		this.codigo = livro.getCodLivro();
		this.nome = livro.getNome();
		this.edicao = livro.getEdicao();
		this.ano = livro.getAno();
		this.qtde = 1;
		this.autor = livro.getAutor() != null ?  livro.getAutor().getNome() : null;
		this.categoria = livro.getCategoria() != null ? livro.getCategoria().getDescricao() : null;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
