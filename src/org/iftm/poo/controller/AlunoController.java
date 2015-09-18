<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.controller;

import java.util.Date;
import org.iftm.poo.model.domain.Aluno;
import org.iftm.poo.negocio.AlunoService;

/**
 *
 * @author Laura
 */
public class AlunoController {
    
    private final AlunoService alunoService;
    
    public AlunoController(){
        alunoService = new AlunoService();
    }
    
    public Aluno novoAluno(String matricula, String nome, String cpf, Date nascimento, String endereco, String genero) throws Exception {
        Aluno aluno = new Aluno(matricula, nome, cpf, nascimento, endereco, genero);
        alunoService.salvarAluno(aluno);
        return aluno;
    }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.controller;

import java.util.Date;
import org.iftm.poo.model.domain.Aluno;
import org.iftm.poo.negocio.AlunoService;

/**
 *
 * @author Laura
 */
public class AlunoController {
    
    private final AlunoService alunoService;
    
    public AlunoController(){
        alunoService = new AlunoService();
    }
    
    public Aluno novoAluno(String matricula, String nome, String cpf, Date nascimento, String endereco, String genero) throws Exception {
        Aluno aluno = new Aluno(matricula, nome, cpf, nascimento, endereco, genero);
        alunoService.salvarAluno(aluno);
        return aluno;
    }
    
}
>>>>>>> e357ef5c3b439ec742408531657b5b15812fd5a1
