/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.main;

import java.util.Scanner;

/**
 *
 * @author vhmolinar
 */
public abstract class UC {
    private static Scanner scanner;
    private static UC instance;
    
    
    public static UC apresentaCasosDeUso() throws Exception{
        scanner = new Scanner(System.in); 
        
        System.out.println("Escolha o caso de uso para execução(digite o nro)");
        System.out.println("\n");
        System.out.println("1 - UC009: Realizar empréstimo (Laura)");
        System.out.println("2 - UC014: Consultar empréstimo (Laura)");
        System.out.println("3 - UC008: Realizar reserva (Max)");
        System.out.println("4 - UC013: Consultar reserva (Max)");
        System.out.println("5 - UC012: Renovar Empréstimo (Wisney)");
        System.out.println("6 - UC017 - Consultar Livros (Victor Hugo)");
        System.out.println("7 - UC018 - Gerenciar Empréstimos (Victor Hugo)");
        
        int uc = scanner.nextInt();
        switch(uc){
            case 1:
                instance = new UC009();
                break;
            case 2:
                instance = new UC014();
                break;
            case 3:
                instance = new UC008();
                break;
            case 4:
                instance = new UC013();
                break;
            case 5:
                instance = new UC012();
                break;
            case 6:
                instance = new UC017();
                break;
            case 7:
                instance = new UC018();
                break;
            default:
                throw new Exception("Opcao invalida!");
        }
        
        return instance;
    }
    
    protected String lerEntrada(){
        return scanner.next();
    }
    
    protected Integer lerEntradaInteira(){
        return Integer.valueOf(lerEntrada());
    }    
    
    protected boolean yesno() {
        System.out.println("Y/N");
        String resposta = scanner.next().toLowerCase();
        if(resposta.equalsIgnoreCase("y")){
            System.out.println("Digite...");
            return true;
        } else {
            return false;
        }
    }
    
    
    public UC preparaCasoDeUso(){
        System.out.println("Preparando dados...");
        return this.preparaBase();
    }
    
    protected abstract UC preparaBase(); 
    public abstract void realiza();
}
