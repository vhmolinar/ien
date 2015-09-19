/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import java.util.List;

import org.iftm.poo.model.dao.CategoriaDao;
import org.iftm.poo.model.domain.Categoria;
import org.iftm.poo.service.DaoFactory;

/**
 * Design pattern Facade
 * 
 * @author vhmolinar
 */
public class CategoriaService {
    
    private final CategoriaDao categoriaDao;
    
    public CategoriaService(){
        categoriaDao = DaoFactory.get().resolve(Categoria.class);
    }
    
    public Categoria salvarAtualizarCategoria(Categoria categoria) throws Exception{
    	return categoriaDao.salvarAtualizar(categoria);
    }
    
    public List<Categoria> pesquisarPorExemplo(Categoria categoria) throws Exception{        
        return categoriaDao.pesquisar(categoria);
    }
    
    public void excluirPorExemplo(Categoria categoria) throws Exception{
        categoriaDao.excluir(categoria);
    }
	
	public Categoria pesquisarPorCodigo(Integer codCategoria) throws Exception {
        Categoria a = new Categoria();
        a.setCodCategoria(codCategoria);
        return categoriaDao.pesquisar(a).get(0);
    }
    
    public List<Categoria> pesquisarTodos() throws Exception{
        Categoria categoria = new Categoria();
        return categoriaDao.pesquisar(categoria);
    }
            

    public void excluirPorCodigo(Integer codigo) throws Exception{
    	Categoria categoria = new Categoria();
    	categoria.setCodCategoria(codigo);
    	categoriaDao.excluir(categoria);
    }
}
