package com.service.db.dao;

import java.util.List;

import com.service.db.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);
}
