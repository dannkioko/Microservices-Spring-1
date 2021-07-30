package com.service.order.dao;

import java.util.List;

import com.service.order.model.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Cart, Integer>{
    List<Cart> findByUserId(int id);
}
