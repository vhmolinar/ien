/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import java.util.List;
import javax.persistence.EntityManager;
import org.iftm.poo.model.dao.GenericDao;
import org.iftm.poo.model.dao.PessoaDao;
import org.iftm.poo.model.dao.UsuarioDao;
import org.iftm.poo.model.domain.Pessoa;
import org.iftm.poo.model.domain.Usuario;
import org.iftm.poo.service.DaoFactory;

import static org.iftm.poo.model.dao.TemplateDao.ComandoPersistencia;

/**
 *
 * @author vhmolinar
 */
public class UsuarioService {
    private final UsuarioDao usuarioDao;
    private final PessoaDao pessoaDao;
    private final GenericDao dao;
    
    public UsuarioService(){
        usuarioDao = DaoFactory.get().resolve(Usuario.class);
        pessoaDao = DaoFactory.get().resolve(Pessoa.class);
        dao = DaoFactory.get().resolve();
    }
    
    public Usuario autentica(String login, String senha) throws Exception{
        if(login == null || senha == null){
            throw new Exception("Credenciais requeridas para autenticaçãDo!");
        }
        return usuarioDao.autentica(login, senha);
    }
    
    public Usuario cadastra(String login, String senha, Pessoa pessoa) throws Exception{
        if(login == null || senha == null || pessoa == null){
            throw new Exception("Forneça os dados para cadastro de usuario!");
        }
        
        return (Usuario) dao.operacaoAtomica(new ComandoPersistencia() {
            @Override
            public Object execute(EntityManager em) throws Exception {
                Pessoa pessoaPersistida = pessoaDao.salvarAtualizar(em, pessoa);
                Usuario usuario = new Usuario(login, senha, pessoaPersistida);
                return usuarioDao.salvarAtualizar(em, usuario);
            }
        });
    }
    
    public List<Usuario> pesquisarPorExemplo(Usuario usuario) throws Exception{        
        return usuarioDao.pesquisar(usuario);
    }
    
    public List<Usuario> pesquisarTodos() throws Exception{   
        Usuario usuario = new Usuario();
        return usuarioDao.pesquisar(usuario);
    }
    
    public Usuario pesquisarPorCodigo(Integer codUsuario) throws Exception{        
        Usuario usuario = new Usuario();
        usuario.setCodUsuario(codUsuario);
        return usuarioDao.pesquisar(usuario).get(0);
    }   
    
    public void excluirPorExemplo(Usuario usuario) throws Exception{
        usuarioDao.excluir(usuario);
    }
}
