/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author estudiantes
 */
public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String id){
        super("Can't find a Order with id " + id);
    }
    
}
