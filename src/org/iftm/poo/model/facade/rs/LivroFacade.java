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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.negocio.LivroService;

@Path("/livro")
@Produces({
	MediaType.APPLICATION_JSON})
@Consumes({
	MediaType.TEXT_PLAIN,
	MediaType.APPLICATION_JSON})
public class LivroFacade {
	
	@Inject
	private LivroService livroService;	
	
	@GET
	public List<Livro> getLivros() throws Exception{
		List<Livro> al = new ArrayList<Livro>();
		al = livroService.pesquisarTodos();
		return al;		
	}

	@POST
	public void setLivro(Livro livro) throws Exception{
		livroService.salvarAtualizarLivro(livro, 1);
	}
	
	@PUT
	public void updateLivro(Livro livro) throws Exception{
		livroService.salvarAtualizarLivro(livro, 1);
	}
	
	@DELETE
	public void dropLivro(Livro livro) throws Exception{
		livroService.excluirPorExemplo(livro);
	}

}
