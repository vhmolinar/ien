/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Design Pattern Singleton
 * @author vhmolinar
 */
public class Conexao {
    private static EntityManagerFactory emf;
    
    
    private static Conexao instance;
    private Conexao(){
        emf = Persistence.createEntityManagerFactory("ienPU");
    }
    
    public static Conexao get(){
        if(instance == null){
            instance = new Conexao();
        }
        return instance;
    }
    
    public synchronized EntityManager createEM(){
        return emf.createEntityManager();
    }
    
    public EntityManager inicia(){
        return createEM();
    }
    
    public void fecha(){
        emf.close();
    }
}
