package org.iftm.poo.boundary;

<<<<<<< HEAD
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
	
=======
import org.iftm.poo.model.domain.Autor;

public class AutorDTO {

	private String nome;
	private Integer codigo;
	
	public AutorDTO(Autor autor){
		this.nome = autor.getNome();
		this.codigo = autor.getCodAutor();
	}

>>>>>>> 2a0cfe6ecdf2accfc064700d85d1eeb722ad8e75
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
<<<<<<< HEAD
=======

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
>>>>>>> 2a0cfe6ecdf2accfc064700d85d1eeb722ad8e75
}
