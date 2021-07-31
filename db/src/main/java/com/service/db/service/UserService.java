package com.service.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.service.db.dao.UserDAO;
import com.service.db.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO dao){
        this.userDAO = dao;
    }

    public List<User> getUsers(){
        return userDAO.findAll();
    }
    public User addUser(User user){
        return userDAO.save(user);
    }
    public List<String> getUserByEmail( String email){
        List<User> users = userDAO.findByEmail(email);
        List<String> names = new ArrayList<String>();
        for(User usr: users){
            names.add(usr.getFirstname()+" "+usr.getLastname());
        }
        return names;
    }
    public Optional<User> getUser(Long id){
        return userDAO.findById(id);
    }
    public User updateUser(User user, Long id){
        User s = userDAO.getById(id);
        s.setFirstname(user.getFirstname());
        s.setLastname(user.getLastname());
        s.setEmail(user.getEmail());
        s.setPhonenumber(user.getPhonenumber());
        return userDAO.save(s);
    }
    public void delete(Long id){
        User user = userDAO.getById(id);
        userDAO.delete(user);
    }
}
