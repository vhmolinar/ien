package org.iftm.poo.boundary;

<<<<<<< HEAD
import java.io.Serializable;

import org.iftm.poo.model.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String descricao;
	
	public CategoriaDTO(){
		
	}	


	public CategoriaDTO(Categoria categoria){
		this.codigo = categoria.getCodCategoria();
		this.descricao = categoria.getDescricao();
	}	
	
=======
import org.iftm.poo.model.domain.Categoria;

public class CategoriaDTO {

	private String descricao;
	private Integer codigo;
	
	public CategoriaDTO(Categoria categoria){
		this.descricao = categoria.getDescricao();
		this.codigo = categoria.getCodCategoria();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
>>>>>>> 2a0cfe6ecdf2accfc064700d85d1eeb722ad8e75

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
<<<<<<< HEAD
	public String getNome() {
		return descricao;
	}

	public void setNome(String descricao) {
		this.descricao = descricao;
	}
=======
>>>>>>> 2a0cfe6ecdf2accfc064700d85d1eeb722ad8e75
}
