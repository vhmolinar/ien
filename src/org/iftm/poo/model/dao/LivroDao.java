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
public class LivroDao extends TemplateDao<Livro>{
    
    public LivroDao(){
        this.tipoEntidade = Livro.class;
    }

    @Override
    protected Livro salvarAtualizarImpl(EntityManager em, Livro livro) throws Exception {
        if(livro.getCodLivro() != null){
            livro = em.merge(livro);
        }
        em.persist(livro);
        return livro;
    }
    
    @SuppressWarnings("unchecked")
	public List<Livro> buscarLivrosEmprestimoUsuario(Usuario usuario) throws Exception{
        return (List<Livro>) operacaoTransacional(new ComandoPersistencia() {
            @Override
            public Object execute(EntityManager em) throws Exception {
                StringBuilder sql = new StringBuilder("select l.* from livro l ");
                sql.append("inner join item_livro il on il.cod_livro = l.cod ");
                sql.append("inner join item_emprestimo ie on ie.cod_item_livro=il.cod ");
                sql.append("inner join emprestimo e on e.cod = ie.cod_emprestimo ");
                sql.append("where e.cod_usuario = :codUsuario ");

                Query query = em.createNativeQuery(sql.toString(), Livro.class);
                query.setParameter("codUsuario", usuario.getCodUsuario());

                return query.getResultList();
            }
        });
    }
    
	@SuppressWarnings("unchecked")
	@Override
    protected List<Livro> pesquisar(EntityManager em, Livro livro) throws Exception {
        StringBuilder sql = new StringBuilder("select livro from Livro as livro ");
        sql.append(" inner join fetch livro.categoria as categoria");
        sql.append(" inner join fetch livro.autor as autor");
        sql.append(" where 1=1 ");
        
        if(livro.getCodLivro() != null){
            sql.append("and livro.codLivro = :codigo ");
        }
        if(livro.getEdicao() != null && !livro.getEdicao().equals("")){
            sql.append("and livro.edicao like :edicao ");
        }
        if(livro.getAno() != null){
            sql.append("and livro.ano = :ano ");
        }
        if(livro.getNome() != null && !livro.getNome().equals("")){
            sql.append("and livro.nome like :nome ");
        }

        if(livro.getCategoria() != null && 
            livro.getCategoria().getDescricao() != null && !livro.getCategoria().getDescricao().equals("")){
            sql.append("and categoria.descricao like :categoria");
        }
        if(livro.getAutor() != null && 
            livro.getAutor().getNome() != null &&
            !livro.getAutor().getNome().equals("")){
            sql.append("and autor.nome like :autor");
        }

        
        Query query = em.createQuery(sql.toString());
        if(livro.getCodLivro() != null){
            query.setParameter("codigo", livro.getCodLivro());
        }
        if(livro.getEdicao() != null && !livro.getEdicao().equals("")){
            query.setParameter("edicao", "%" + livro.getEdicao().toLowerCase() + "%");
        }
        if(livro.getAno() != null){
            query.setParameter("ano", livro.getAno());
        }
        if(livro.getNome() != null && !livro.getNome().equals("")){
            query.setParameter("nome", "%" + livro.getNome().toLowerCase() + "%");
        }
        if(livro.getCategoria() != null && 
            livro.getCategoria().getDescricao() != null && !livro.getCategoria().getDescricao().equals("")){
            query.setParameter("categoria", "%" + livro.getCategoria().getDescricao().toLowerCase() + "%");
        }
        if(livro.getAutor() != null && 
            livro.getAutor().getNome() != null &&
            !livro.getAutor().getNome().equals("")){
            query.setParameter("autor", "%" + livro.getAutor().getNome().toLowerCase() + "%");
        }
        
        return query.getResultList();
    }
}
