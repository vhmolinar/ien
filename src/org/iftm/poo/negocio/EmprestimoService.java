/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.iftm.poo.model.dao.EmprestimoDao;
import org.iftm.poo.model.dao.GenericDao;
import org.iftm.poo.model.dao.ItemEmprestimoDao;
import org.iftm.poo.model.dao.ItemLivroDao;
import org.iftm.poo.model.dao.TemplateDao;
import org.iftm.poo.model.domain.Emprestimo;
import org.iftm.poo.model.domain.ItemEmprestimo;
import org.iftm.poo.model.domain.ItemLivro;
import org.iftm.poo.model.domain.StatusLivro;
import org.iftm.poo.model.domain.TipoPessoa;
import org.iftm.poo.model.domain.Usuario;
import org.iftm.poo.service.DaoFactory;

/**
 *
 * @author Laura
 */
public class EmprestimoService {
    
    private final EmprestimoDao emprestimoDao;
    private final GenericDao genericDao;
    private final ItemLivroDao itemLivroDao;
    private final ItemEmprestimoDao itemEmprestimoDao;
    
  
    public EmprestimoService(){
        emprestimoDao = DaoFactory.get().resolve(Emprestimo.class);
        DaoFactory.get().resolve(Usuario.class);
        itemLivroDao = DaoFactory.get().resolve(ItemLivro.class);
        genericDao = DaoFactory.get().resolve();
        itemEmprestimoDao = DaoFactory.get().resolve(ItemEmprestimo.class);
    }
    
    public Emprestimo novoEmprestimo(Usuario usuario, List<ItemLivro> itensLivro) throws Exception{
        return (Emprestimo) genericDao.operacaoAtomica(new TemplateDao.ComandoPersistencia() {

            @Override
            public Object execute(EntityManager em) throws Exception {
                
                List<ItemEmprestimo> itens = new ArrayList<>();
                for(ItemLivro itemLivro : itensLivro){
                    itemLivro.setStatusLivro(StatusLivro.Emprestado);
                    itemLivroDao.salvarAtualizar(em, itemLivro);
                    
                    ItemEmprestimo iEmp = new ItemEmprestimo(itemLivro);
                    itens.add(iEmp);
                }
                
                Emprestimo emprestimo = new Emprestimo(usuario, itens);
                emprestimo =  emprestimoDao.salvarAtualizar(em, emprestimo);
                
                for(ItemEmprestimo itemEmprestimo : itens){
                    itemEmprestimo.setEmprestimo(emprestimo);
                    itemEmprestimoDao.salvarAtualizar(em, itemEmprestimo);
                }
                
                return emprestimo;
            }
        });
    }
    
        
    public List<Emprestimo> pesquisarPorExemplo(Emprestimo emprestimo) throws Exception{        
        return emprestimoDao.pesquisar(emprestimo);
    }
    
    public List<Emprestimo> pesquisarPorUsuario(Usuario usuario) throws Exception{
        Emprestimo emprestimo = new Emprestimo();
        if(!usuario.getPessoa().tipoPessoa().equals(TipoPessoa.Administrador)){
            emprestimo.setUsuario(usuario);
            //System.out.println("Não é adm!!");
        }
        return emprestimoDao.pesquisar(emprestimo);
    }
    
    public void excluirPorExemplo(Emprestimo emprestimo) throws Exception{
        emprestimoDao.excluir(emprestimo);
    }
    
    public List<ItemEmprestimo> itensEmprestimo(Emprestimo emprestimo)throws Exception{
         return emprestimoDao.itensEmprestimo(emprestimo);
     }
    
    
    public Emprestimo atualizar(Emprestimo emprestimo) throws Exception{
        return emprestimoDao.salvarAtualizar(emprestimo);
    }
    
}