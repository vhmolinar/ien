/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.main;

import org.iftm.poo.model.dao.Conexao;

/**
 *
 * @author vhmolinar
 */
public class Main {
    public static void main(String[]args) throws Exception{
        
        Conexao.get().inicia();
        
        UC.apresentaCasosDeUso().preparaCasoDeUso().realiza();        
        
        Conexao.get().fecha();
        
        System.exit(1);
    }
}
