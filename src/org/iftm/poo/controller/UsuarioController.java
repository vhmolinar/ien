/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.iftm.poo.model.domain.Pessoa;
import org.iftm.poo.model.domain.Usuario;
import org.iftm.poo.negocio.UsuarioService;

/**
 *
 * @author vhmolinar
 */
public class UsuarioController {
    private final UsuarioService usuarioService;
    
    public UsuarioController(){
        usuarioService = new UsuarioService();
    }
    
    public Usuario autentica(String login, String senha){
        try {
            return usuarioService.autentica(login, senha);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Usuario cadastraUsuario(String login, String senha, Pessoa pessoa) throws Exception{
        try {
            return usuarioService.cadastra(login, senha, pessoa);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }
    
    public List<Usuario> buscarTodosUsuarios() throws Exception{
        return usuarioService.pesquisarTodos();
    }
    
    public List<Usuario> pesquisarPorExemplo(Integer codUsuario) throws Exception{ 
        Usuario usuario = new Usuario();
        usuario.setCodUsuario(codUsuario);
        return usuarioService.pesquisarPorExemplo(usuario);
    }
}
