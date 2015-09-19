package org.iftm.poo.boundary;

import java.io.Serializable;

import org.iftm.poo.model.domain.Autor;

public class AutorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String nome;
	
	public AutorDTO(){
		
	}	


	public AutorDTO(Autor autor){
		this.codigo = autor.getCodAutor();
		this.nome = autor.getNome();
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
}
