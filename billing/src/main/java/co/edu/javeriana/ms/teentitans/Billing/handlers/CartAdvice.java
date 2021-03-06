/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import co.edu.javeriana.ms.teentitans.Billing.exceptions.ServiceDoesNotExistException;
import exceptions.CartNotFoundException;
import exceptions.UnableToCompletePurchaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author estudiantes
 */
@RestControllerAdvice
public class CartAdvice {
    @ResponseBody
    @ExceptionHandler(CartNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String cartNotFound(CartNotFoundException e){
        return e.getMessage();
    }
    
    @ResponseBody
    @ExceptionHandler(UnableToCompletePurchaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String internalError(UnableToCompletePurchaseException e){
        return e.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(ServiceDoesNotExistException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String internalError(ServiceDoesNotExistException e){
        return e.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String internalError(RuntimeException e){
        return e.getMessage();
    }
}
