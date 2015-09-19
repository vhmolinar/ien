/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import java.util.List;

import org.iftm.poo.model.dao.AutorDao;
import org.iftm.poo.model.domain.Autor;
import org.iftm.poo.service.DaoFactory;

/**
 * Design pattern Facade
 * 
 * @author vhmolinar
 */
public class AutorService {
    
    private final AutorDao autorDao;
    
    public AutorService(){
        autorDao = DaoFactory.get().resolve(Autor.class);
    }
    
    public Autor salvarAtualizarAutor(Autor autor) throws Exception{
    	return autorDao.salvarAtualizar(autor);
    }
    
    public List<Autor> pesquisarPorExemplo(Autor autor) throws Exception{        
        return autorDao.pesquisar(autor);
    }
    
    public void excluirPorExemplo(Autor autor) throws Exception{
        autorDao.excluir(autor);
    }
    
    public void excluirPorCodigo(Integer codigo) throws Exception{

		Autor autor = new Autor();
		autor.setCodAutor(codigo);
		
		autorDao.excluir(autor);
    }
	
	public Autor pesquisarPorCodigo(Integer codAutor) throws Exception {
        Autor a = new Autor();
        a.setCodAutor(codAutor);
        return autorDao.pesquisar(a).get(0);
    }
    
    public List<Autor> pesquisarTodos() throws Exception{
        Autor autor = new Autor();
        return autorDao.pesquisar(autor);
    }
            
}
