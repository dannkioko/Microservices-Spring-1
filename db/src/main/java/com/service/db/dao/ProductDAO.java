package com.service.db.dao;

import java.util.List;

import com.service.db.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer>{
    
}
