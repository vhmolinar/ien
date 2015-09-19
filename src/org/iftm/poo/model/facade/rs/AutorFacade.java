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

import org.iftm.poo.boundary.AutorDTO;
import org.iftm.poo.model.domain.Autor;
import org.iftm.poo.negocio.AutorService;

@Path("/autor")
@Produces({
	MediaType.APPLICATION_JSON})
@Consumes({
	MediaType.APPLICATION_JSON})
public class AutorFacade {
	
	@Inject
	private AutorService autorService;	
	
	@GET
	public List<AutorDTO> getAutors() throws Exception{
		List<AutorDTO> al = new ArrayList<AutorDTO>();
		for (Autor autor: autorService.pesquisarTodos()){
			al.add(new AutorDTO(autor));
		}
		return al;		
	}

	@POST
	public void salvarAutor(AutorDTO autorDTO) throws Exception{
		Autor autor = new Autor();
		autor.setCodAutor(autorDTO.getCodigo());
		autor.setNome(autorDTO.getNome());
		
		
		autorService.salvarAtualizarAutor(autor);
	}

	@PUT
	@Path("{codigo}")
	public void atualizarAutor(@PathParam("codigo") Integer codigo, AutorDTO autorDTO) throws Exception{
		Autor autor = new Autor();
		autor.setCodAutor(autorDTO.getCodigo());
		autor.setNome(autorDTO.getNome());
		
		
		autorService.salvarAtualizarAutor(autor);
	}
	
	@DELETE
	@Path("{codigo}")
	public void apagarAutor(@PathParam("codigo") Integer codigo) throws Exception{
		autorService.excluirPorCodigo(codigo);
	}

}
