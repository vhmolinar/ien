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
import org.iftm.poo.boundary.CategoriaDTO;
import org.iftm.poo.boundary.LivroDTO;
import org.iftm.poo.model.domain.Autor;
import org.iftm.poo.model.domain.Categoria;
import org.iftm.poo.model.domain.ItemLivro;
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.StatusLivro;
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
	public List<LivroDTO> getLivros() throws Exception{
		List<LivroDTO> al = new ArrayList<LivroDTO>();
		for (Livro livro: livroService.pesquisarTodos()){
			al.add(new LivroDTO(livro));
		}
		return al;		
	}

	@POST
	public void salvarLivro(LivroDTO livroDTO) throws Exception{		
		Livro livro = new Livro();
		livro.setNome(livroDTO.getNome());
		livro.setAno(livroDTO.getAno());
		livro.setEdicao(livroDTO.getEdicao());
		
		Autor autor = new Autor();
		autor.setCodAutor(livroDTO.getCodAutor());
		livro.setAutor(autor);
		
		Categoria categoria = new Categoria();
		categoria.setCodCategoria(livroDTO.getCodCategoria());
		livro.setCategoria(categoria);
		
		ItemLivro item = new ItemLivro();
		item.setLivro(livro);
		item.setStatusLivro(StatusLivro.Disponivel);
		List<ItemLivro> itens = new ArrayList<ItemLivro>();
		itens.add(item);
		
		livro.setItens(itens);
		
		livroService.salvarAtualizarLivro(livro, livroDTO.getQtde());
	}
	
	@PUT
	public void atualizarLivro(LivroDTO livroDTO) throws Exception{
		Livro livro = new Livro();
		livro.setCodLivro(livroDTO.getCodigo());
		livro.setNome(livro.getNome());
		livro.setAno(livroDTO.getAno());
		livro.setEdicao(livroDTO.getEdicao());
		
		Autor autor = new Autor();
		autor.setCodAutor(livroDTO.getCodAutor());
		livro.setAutor(autor);
		
		Categoria categoria = new Categoria();
		categoria.setCodCategoria(livroDTO.getCodCategoria());
		livro.setCategoria(categoria);
		
		ItemLivro item = new ItemLivro();
		item.setLivro(livro);
		item.setStatusLivro(StatusLivro.Disponivel);
		List<ItemLivro> itens = new ArrayList<ItemLivro>();
		itens.add(item);
		
		livro.setItens(itens);
		livroService.salvarAtualizarLivro(livro, livroDTO.getQtde());
	}
	
	@DELETE
	@Path("{codigo}")
	public void apagarLivro(@PathParam("codigo") Integer codigo) throws Exception{
		livroService.excluirPorCodigo(codigo);
	}
	
	@POST
	@Path("/categoria")
	public void salvarCategoria(CategoriaDTO categoriaDto) throws Exception{
		Categoria categoria = new Categoria();
		categoria.setDescricao(categoriaDto.getDescricao());
		
		livroService.salvarAtualizarCategoria(categoria);
	}
	
	@PUT
	@Path("/categoria")
	public void atualizarCategoria(CategoriaDTO categoriaDto) throws Exception{
		Categoria categoria = new Categoria();
		categoria.setCodCategoria(categoriaDto.getCodigo());
		categoria.setDescricao(categoriaDto.getDescricao());
		
		livroService.salvarAtualizarCategoria(categoria);
	}
	
	@GET
	@Path("/categoria")
	public List<CategoriaDTO> getCategorias() throws Exception{
		List<Categoria> categorias = livroService.pesquisarCategorias();
		
		List<CategoriaDTO> categoriasDto = new ArrayList<>();
		for(Categoria categoria : categorias){
			categoriasDto.add(new CategoriaDTO(categoria));
		}
		
		return categoriasDto;
	}
	
	@DELETE
	@Path("{codigo}")
	public void apagarCategoria(Integer codigo) throws Exception{
		livroService.apagarCategoriaPorcodigo(codigo);
	}
	
	@GET
	@Path("/autor")	
	public List<AutorDTO> getAutores() throws Exception {
		List<Autor> autores = livroService.pesquisarAutores();
		
		List<AutorDTO> autoresDTO = new ArrayList<>();
		for(Autor autor : autores){
			autoresDTO.add(new AutorDTO(autor));
		}
		
		return autoresDTO;
	}
	
	@POST
	@Path("/autor")
	public void salvarAutor(AutorDTO autorDTO) throws Exception{
		Autor autor = new Autor();
		autor.setNome(autorDTO.getNome());
		
		livroService.salvarAtualizarAutor(autor);
	}
	
	@PUT
	@Path("/autor")
	public void atualizarAutor(AutorDTO autorDTO) throws Exception{
		Autor autor = new Autor();
		autor.setCodAutor(autorDTO.getCodigo());
		autor.setNome(autorDTO.getNome());
		
		livroService.salvarAtualizarAutor(autor);
	}
	
	@DELETE
	@Path("{codigo}")
	public void apagarAutor(Integer codigo) throws Exception{
		livroService.apagarCategoriaPorcodigo(codigo);
	}
}
