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
public class UnableToCompletePurchaseException extends RuntimeException {
    public UnableToCompletePurchaseException(String id){
        super("Unable to complete purchase for cart " + id + "\nAborting purchase process.");
    }
    
}
