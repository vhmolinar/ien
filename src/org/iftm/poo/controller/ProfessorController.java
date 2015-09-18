/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.controller;

import java.util.Date;
import org.iftm.poo.model.domain.Professor;
import org.iftm.poo.negocio.ProfessorService;

/**
 *
 * @author Laura
 */
public class ProfessorController {
    
    private final ProfessorService professorService;
    
    public ProfessorController(){
        professorService = new ProfessorService();
    }
    
    public Professor novoProfessor(Integer matricula, String nome, String cpf, Date nascimento, String endereco, String genero) throws Exception {
        Professor professor = new Professor(matricula, nome, cpf, nascimento, endereco, genero);
        professorService.salvarProfessor(professor);
        return professor;
    }
}