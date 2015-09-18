/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.Usuario;

/**
 *
 * @author vhmolinar
 */
public class UsuarioDao extends TemplateDao<Usuario>{

    public UsuarioDao(){
        this.tipoEntidade = Usuario.class;
    }
    
    @Override
    protected Usuario salvarAtualizarImpl(EntityManager em, Usuario usuario) throws Exception {
        if(usuario.getCodUsuario() != null){
            usuario = em.merge(usuario);
        }
        em.persist(usuario);
        return usuario;
    }
    
    public Usuario autentica(final String login, final String senha) throws Exception{
        return (Usuario) operacaoTransacional(new ComandoPersistencia() {
            @Override
            public Object execute(EntityManager em) throws Exception {
                StringBuilder sql = new StringBuilder("from Usuario ");
                sql.append("where login like :login ");
                sql.append("and senha like :senha");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("login", login);
                query.setParameter("senha", senha);
                return query.getSingleResult();
            }
        });
    }
    
    public Usuario buscaPorCodigo(Integer codUsuario) throws Exception{
        Usuario exemplo = new Usuario();
        List<Usuario> resultado = pesquisar(exemplo);
        if(resultado.isEmpty()){
            return null;
        }else{
            return resultado.get(0);
        }
    }
}
