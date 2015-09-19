package org.iftm.poo.boundary;

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
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}