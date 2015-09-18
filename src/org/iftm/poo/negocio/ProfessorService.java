<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import org.iftm.poo.model.dao.ProfessorDao;
import org.iftm.poo.model.domain.Professor;
import org.iftm.poo.service.DaoFactory;

/**
 *
 * @author Laura
 */
public class ProfessorService {
    
    private final ProfessorDao professorDao;
  
    public ProfessorService(){
        professorDao = DaoFactory.get().resolve(Professor.class);
    }
    
    public void salvarProfessor(Professor professor) throws Exception{
        
        professorDao.salvarAtualizar(professor);
        
    }
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import org.iftm.poo.model.dao.ProfessorDao;
import org.iftm.poo.model.domain.Professor;
import org.iftm.poo.service.DaoFactory;

/**
 *
 * @author Laura
 */
public class ProfessorService {
    
    private final ProfessorDao professorDao;
  
    public ProfessorService(){
        professorDao = DaoFactory.get().resolve(Professor.class);
    }
    
    public void salvarProfessor(Professor professor) throws Exception{
        
        professorDao.salvarAtualizar(professor);
        
    }
    
}
>>>>>>> e357ef5c3b439ec742408531657b5b15812fd5a1
