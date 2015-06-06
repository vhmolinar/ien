/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import java.util.ArrayList;
import java.util.List;
import org.iftm.poo.model.dao.AutorDao;
import org.iftm.poo.model.dao.CategoriaDao;
import org.iftm.poo.model.dao.ItemLivroDao;
import org.iftm.poo.model.dao.LivroDao;
import org.iftm.poo.model.domain.Autor;
import org.iftm.poo.model.domain.Categoria;
import org.iftm.poo.model.domain.ItemLivro;
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.StatusLivro;
import org.iftm.poo.model.domain.Usuario;
import org.iftm.poo.service.DaoFactory;

/**
 * Design pattern Facade
 * 
 * @author vhmolinar
 */
public class LivroService {
    
    private final LivroDao livroDao;
    private final CategoriaDao categoriaDao;
    private final ItemLivroDao itemLivroDao;
    private final AutorDao autorDao;
    
    public LivroService(){
        livroDao = DaoFactory.get().resolve(Livro.class);
        itemLivroDao = DaoFactory.get().resolve(ItemLivro.class);
        categoriaDao = DaoFactory.get().resolve(Categoria.class);
        autorDao = DaoFactory.get().resolve(Autor.class);
    }
    
    public Livro salvarAtualizarLivro(Livro livro, Integer qtde) throws Exception{
        
        if(livro.getCategoria() == null){
            throw new Exception("Categoria é necessária para identificação do livro.");
        }
        
        Categoria categoria = categoriaDao.buscaPorDescricao(livro.getCategoria().getDescricao());
        if(categoria == null){
            categoria = categoriaDao.salvarAtualizar(livro.getCategoria());
        }
        livro.setCategoria(categoria);
        
        Autor autor = autorDao.buscaPorNome(livro.getAutor().getNome());
        if(autor == null){
            autor = autorDao.salvarAtualizar(livro.getAutor());
        }
        livro.setAutor(autor);
        
        livro = livroDao.salvarAtualizar(livro);
        List<ItemLivro> itens = new ArrayList<>();
        for(int i=0; i<qtde; ++i){
            ItemLivro itemLivro = new ItemLivro();
            itemLivro.setLivro(livro);
            itemLivro.setStatusLivro(StatusLivro.Disponivel);
            itemLivroDao.salvarAtualizar(itemLivro);
            itens.add(itemLivro);
        }
        livro.setItens(itens);
        return livro;
    }
    
    public List<Livro> pesquisarPorExemplo(Livro livro) throws Exception{        
        return livroDao.pesquisar(livro);
    }
    
    public void excluirPorExemplo(Livro livro) throws Exception{
        livroDao.excluir(livro);
    }
	
	public Livro pesquisarPorCodigo(Integer codLivro) throws Exception {
        Livro l = new Livro();
        l.setCodLivro(codLivro);
        return livroDao.pesquisar(l).get(0);
    }
    
    public List<Livro> buscarLivrosEmprestimoUsuario(Usuario usuario) throws Exception{
        return livroDao.buscarLivrosEmprestimoUsuario(usuario);
    }

    public List<Livro> pesquisarTodos() throws Exception{
        Livro livro = new Livro();
        return livroDao.pesquisar(livro);
    }
            
}
