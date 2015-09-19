package org.iftm.poo.boundary;

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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
