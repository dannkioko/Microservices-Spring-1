package com.service.user.api;

import com.service.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/users")
public class UserController{
    @Autowired
    private RestTemplate tmp;

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") int id){
        return tmp.getForObject("http://localhost:8080/api/db/users/"+Integer.toString(id), User.class);
    }
}