/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.service;

import org.iftm.poo.model.dao.AlunoDao;
import org.iftm.poo.model.dao.AutorDao;
import org.iftm.poo.model.dao.CategoriaDao;
import org.iftm.poo.model.dao.EmprestimoDao;
import org.iftm.poo.model.dao.GenericDao;
import org.iftm.poo.model.dao.ItemEmprestimoDao;
import org.iftm.poo.model.dao.ItemLivroDao;
import org.iftm.poo.model.dao.LivroDao;
import org.iftm.poo.model.dao.PessoaDao;
import org.iftm.poo.model.dao.ProfessorDao;
import org.iftm.poo.model.dao.ReservaDao;
import org.iftm.poo.model.dao.TemplateDao;
import org.iftm.poo.model.dao.UsuarioDao;
import org.iftm.poo.model.domain.Aluno;
import org.iftm.poo.model.domain.Autor;
import org.iftm.poo.model.domain.Categoria;
import org.iftm.poo.model.domain.Emprestimo;
import org.iftm.poo.model.domain.ItemEmprestimo;
import org.iftm.poo.model.domain.ItemLivro;
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.Pessoa;
import org.iftm.poo.model.domain.Professor;
import org.iftm.poo.model.domain.Reserva;
import org.iftm.poo.model.domain.Usuario;

/**
 * Design Patterns
 * 
 * Singleton e Abstract Factory
 * @author vhmolinar
 */
public class DaoFactory {
    
    private static DaoFactory instance;
    
    public static DaoFactory get(){
        if(instance == null){
            instance = new DaoFactory();
        }
        return instance;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public <T extends TemplateDao> T resolve(){
        return (T) new GenericDao();
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public <T extends TemplateDao> T resolve(Class tipoEntidade){
        if(tipoEntidade == Livro.class){
            return (T) new LivroDao();
        } else if(tipoEntidade == ItemLivro.class){
            return (T) new ItemLivroDao();
        } else if(tipoEntidade == Categoria.class){
            return (T) new CategoriaDao();
        } else if(tipoEntidade == Autor.class){
            return (T) new AutorDao();
        } else if(tipoEntidade == Usuario.class){
            return (T) new UsuarioDao();
        } else if(tipoEntidade == Pessoa.class){
            return (T) new PessoaDao();
        } else if(tipoEntidade == Emprestimo.class){
            return (T) new EmprestimoDao();
        } else if(tipoEntidade == Aluno.class){
            return (T) new AlunoDao();
        } else if(tipoEntidade == Professor.class){
            return (T) new ProfessorDao();
        }else if(tipoEntidade == ItemEmprestimo.class){
            return (T) new ItemEmprestimoDao();
        }else if(tipoEntidade == Reserva.class){
            return (T) new ReservaDao();
        } else {
            return resolve();
        }
    }
}
