/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.teentitans.users.services;

import co.edu.javeriana.ms.teentitans.users.model.Client;
import co.edu.javeriana.ms.teentitans.users.model.Request;
import co.edu.javeriana.ms.teentitans.users.model.Session;
import co.edu.javeriana.ms.teentitans.users.model.Supplier;
import co.edu.javeriana.ms.teentitans.users.repository.ClientRepository;
import co.edu.javeriana.ms.teentitans.users.repository.SessionRepository;
import co.edu.javeriana.ms.teentitans.users.repository.SupplierRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author estudiantes
 */
@Service
public class SessionService implements SessionServiceInterface, UserDetailsService {
    
    private final ClientRepository repositoryC;
    private final SupplierRepository repositoryS;
    private final SessionRepository repository;
    
    private final PasswordEncoder  bCryptPasswordEncoder;

    public SessionService(ClientRepository repositoryC, SupplierRepository repositoryS, SessionRepository repository, PasswordEncoder bCryptPasswordEncoder) {
        this.repositoryC = repositoryC;
        this.repositoryS = repositoryS;
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    

    
    public Session createSession(String username, String password) {
        
        Optional<Client> client = repositoryC.findByUsername(username);
        Optional<Supplier> supplier = repositoryS.findByUsername(username);
        
        Session session = new Session();
        if (client != null || supplier != null) {
        
            
            String passwordDB = "";
            if (client.isPresent()){
                passwordDB = client.get().getPassword();
                
                    
            } else if (supplier.isPresent()) {
                passwordDB = supplier.get().getPassword();
            }
            
            
            if (bCryptPasswordEncoder.matches(password, passwordDB)) {
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                String access_token = JWT.create()
                        .withSubject(username)
                        .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                        .sign(algorithm);
                Session sessionOld = repository.findByIdusername(username);
        if ( sessionOld != null )
            return sessionOld;
                
                session.setIdusername(username);
                session.setToken(access_token);
                return repository.save(session);
                
            } 
        }
            throw new UsernameNotFoundException("user not found ");
           
    }
    
    public void deleteSession(String id) {
        repository.deleteById(id);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client>  client = repositoryC.findByUsername(username);
        Optional<Supplier> supplier = repositoryS.findByUsername(username);
        Collection<SimpleGrantedAuthority> au = new ArrayList<>();
        if ( !client.isPresent() && !supplier.isPresent()) {
            throw new UsernameNotFoundException("user not found ");
            
        } else if (!client.isPresent()) {
            return new org.springframework.security.core.userdetails.User(client.get().getUsername(), client.get().getPassword(), au);
        } else {
            
            return new org.springframework.security.core.userdetails.User(supplier.get().getUsername(), supplier.get().getPassword(), au);
        }
    }
    
}
