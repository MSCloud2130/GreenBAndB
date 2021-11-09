/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.users.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * Session
 */
@Data
public class Session {
   
  @Id
  private String id;

  private String token;   
  
  private String idusername;

   
    public Session() {
         }



  
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdusername() {
        return idusername;
    }

    public void setIdusername(String usernameid) {
        this.idusername = usernameid;
    }
  
    
}
