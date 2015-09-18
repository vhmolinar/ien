<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import org.iftm.poo.model.dao.AlunoDao;
import org.iftm.poo.model.domain.Aluno;
import org.iftm.poo.service.DaoFactory;

/**
 *
 * @author Laura
 */
public class AlunoService {
    
    private final AlunoDao alunoDao;
  
    public AlunoService(){
        alunoDao = DaoFactory.get().resolve(Aluno.class);
    }
    
    public void salvarAluno(Aluno aluno) throws Exception{
        
        alunoDao.salvarAtualizar(aluno);
        
    }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import org.iftm.poo.model.dao.AlunoDao;
import org.iftm.poo.model.domain.Aluno;
import org.iftm.poo.service.DaoFactory;

/**
 *
 * @author Laura
 */
public class AlunoService {
    
    private final AlunoDao alunoDao;
  
    public AlunoService(){
        alunoDao = DaoFactory.get().resolve(Aluno.class);
    }
    
    public void salvarAluno(Aluno aluno) throws Exception{
        
        alunoDao.salvarAtualizar(aluno);
        
    }
    
}
>>>>>>> e357ef5c3b439ec742408531657b5b15812fd5a1
