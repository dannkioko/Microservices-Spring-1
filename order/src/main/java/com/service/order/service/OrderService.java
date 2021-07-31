package com.service.order.service;

import java.util.ArrayList;
import java.util.List;

import com.service.order.dao.OrderDAO;
import com.service.order.model.Cart;
import com.service.order.model.OrderObject;
import com.service.order.model.Product;
import com.service.order.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private RestTemplate tmp;

    public Cart add(Cart order){
        Cart saved = orderDAO.save(order);
        return saved;
    }
    public List<Product> getByuser(int userid){
        List<Cart> carts = orderDAO.findByUserId(userid);
        List<Product> products = new ArrayList<>();
        for(Cart c: carts){
            products.add(tmp.getForObject("http://localhost:8080/api/db/products/"+Integer.toString(c.getProdId()), Product.class));
        }
        return products;
    }
    public OrderObject getOrder(int id){
        Cart cart = orderDAO.findById(id).orElse(new Cart());
        User user = tmp.getForObject("http://localhost:8080/api/db/users/"+Integer.toString(cart.getUserId()), User.class);
        Product prod = tmp.getForObject("http://localhost:8080/api/db/products/"+Integer.toString(cart.getProdId()), Product.class);
        OrderObject ord = new OrderObject(user,prod);
        return ord;  
    }
}
