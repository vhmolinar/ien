package org.iftm.poo.boundary;

import org.iftm.poo.model.domain.Autor;

public class AutorDTO {

	private String nome;
	private Integer codigo;
	
	public AutorDTO(){
		
	}
	
	public AutorDTO(Integer codigo, String nome){
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public AutorDTO(Autor autor){
		this.nome = autor.getNome();
		this.codigo = autor.getCodAutor();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
