/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.users.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;


/**
 * Client
 */

@Data
public class Client   {
    
  @Id
  private String id;

  private String username;

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private Integer age;

  private String photo;

 
}

