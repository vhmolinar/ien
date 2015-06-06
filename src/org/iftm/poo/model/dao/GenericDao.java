/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.dao;

/**
 *
 * @author vhmolinar
 */
public class GenericDao  extends TemplateDao{
    public Object operacaoAtomica(ComandoPersistencia comando) throws Exception{
        return operacaoTransacional(comando);
    }
}
