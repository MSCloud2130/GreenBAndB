/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.users.exceptions;

/**
 *
 * @author estudiantes
 */
public class UsernameAlreadyUsedException extends RuntimeException{
    public UsernameAlreadyUsedException(String username){
        super(username + " is already used.");
    }
    
}
