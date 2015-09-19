/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.iftm.poo.model.dao.ItemLivroDao;
import org.iftm.poo.model.dao.LivroDao;
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
    private final ItemLivroDao itemLivroDao;
    
    public LivroService(){
        livroDao = DaoFactory.get().resolve(Livro.class);
        itemLivroDao = DaoFactory.get().resolve(ItemLivro.class);
    }
    
    public Livro salvarAtualizarLivro(Livro livro, Integer qtde) throws Exception{
                
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
    
    public void excluirPorCodigo(Integer codigo) throws Exception{
        Livro livro = new Livro();
        livro.setCodLivro(codigo);
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
