package com.service.db.api;

import java.util.List;
import java.util.Optional;

import com.service.db.model.User;
import com.service.db.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/db/users")
public class UserController{
    private final UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }
    
    @GetMapping
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }
    @GetMapping("{id}")
    public Optional<User> getUser(@PathVariable("id") Long id){
        return service.getUser(id);
    }
    @PutMapping("{id}")
    public void updateUser(@RequestBody User user, @PathVariable("id") Long id){
        service.updateUser(user, id);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

}