/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.Billing.exceptions;

/**
 *
 * @author estudiantes
 */
public class ServiceDoesNotExistException extends RuntimeException {
    public ServiceDoesNotExistException(String serviceID){
        super(serviceID + " not correspond to a known service.");
    }
}
