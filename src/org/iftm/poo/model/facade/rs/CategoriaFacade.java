package org.iftm.poo.model.facade.rs;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.iftm.poo.boundary.CategoriaDTO;
import org.iftm.poo.model.domain.Categoria;
import org.iftm.poo.negocio.CategoriaService;

@Path("/categoria")
@Produces({
	MediaType.APPLICATION_JSON})
@Consumes({
	MediaType.APPLICATION_JSON})
public class CategoriaFacade {
	
	@Inject
	private CategoriaService categoriaService;	
	
	@GET
	public List<CategoriaDTO> getCategorias() throws Exception{
		List<CategoriaDTO> al = new ArrayList<CategoriaDTO>();
		for (Categoria categoria: categoriaService.pesquisarTodos()){
			al.add(new CategoriaDTO(categoria));
		}
		return al;		
	}

	@POST
	public void salvarAtualizarCategoria(CategoriaDTO categoriaDTO) throws Exception{
		Categoria categoria = new Categoria();
		categoria.setCodCategoria(categoriaDTO.getCodigo());
		categoria.setDescricao(categoriaDTO.getDescricao());
		
		
		categoriaService.salvarAtualizarCategoria(categoria);
	}

	@PUT
	@Path("{codigo}")
	public void atualizarCategoria(@PathParam("codigo") Integer codigo, CategoriaDTO categoriaDTO) throws Exception{
		Categoria categoria = new Categoria();
		categoria.setCodCategoria(categoriaDTO.getCodigo());
		categoria.setDescricao(categoriaDTO.getDescricao());
		
		
		categoriaService.salvarAtualizarCategoria(categoria);
	}
		
	@DELETE
	@Path("{codigo}")
	public void apagarCategoria(@PathParam("codigo") Integer codigo) throws Exception{
		categoriaService.excluirPorCodigo(codigo);
	}
}
