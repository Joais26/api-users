package com.devsuperior.userdpt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.userdpt.model.User;
import com.devsuperior.userdpt.repository.UserRepository;

@RestController
@RequestMapping(value= "/users")
public class UserControlers {
    
    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<List<User>> finAll(){
        List<User> resultList = repository.findAll();      
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultList);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Object> finById(@PathVariable Long id){
       Optional<User> result = repository.findById(id);
    
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
        
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Object> finByName(@PathVariable String name){
       Optional<User> result = repository.findByName(name);
    
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
        
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<Object> finByEmail(@PathVariable String email){
       Optional<User> result = repository.findByEmail(email);
    
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
        
    }

     @GetMapping(value = "/name/{name}/email/{email}")
    public ResponseEntity<Object> finByNameAndEmail(@PathVariable String name,@PathVariable String email){
       Optional<User> result = repository.findByNameAndEmail(name,email);
    
        if(result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(result.get());
        
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
    }
}
