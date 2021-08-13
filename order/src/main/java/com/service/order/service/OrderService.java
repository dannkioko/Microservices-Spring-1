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

    public Cart addCart(Cart order){
        Cart saved = orderDAO.save(order);
        return saved;
    }

    public OrderObject add(Cart order){
        Cart saved = orderDAO.save(order);
        User user = tmp.getForObject("http://localhost:8080/api/db/users/"+Integer.toString(saved.getUserId()), User.class);
        Product prod = tmp.getForObject("http://localhost:8080/api/db/products/"+Integer.toString(saved.getProductId()), Product.class);
        OrderObject ord = new OrderObject(user,prod);
        return ord;
    }
    public List<OrderObject> all(){
        List<OrderObject> orders = new ArrayList<>();
        List<Cart> carts = orderDAO.findAll();
        for (Cart cart: carts){
            User user = tmp.getForObject("http://localhost:8080/api/db/users/"+Integer.toString(cart.getUserId()), User.class);
            Product prod = tmp.getForObject("http://localhost:8080/api/db/products/"+Integer.toString(cart.getProductId()), Product.class);
            OrderObject ord = new OrderObject(user,prod);
            orders.add(ord);
        }
        return orders;
    }
    public List<Product> getByuser(int userid){
        List<Cart> carts = orderDAO.findByUserId(userid);
        List<Product> products = new ArrayList<>();
        for(Cart c: carts){
            products.add(tmp.getForObject("http://localhost:8080/api/db/products/"+Integer.toString(c.getProductId()), Product.class));
        }
        return products;
    }
    public OrderObject getOrder(int id){
        Cart cart = orderDAO.findById(id).orElse(new Cart());
        User user = tmp.getForObject("http://localhost:8080/api/db/users/"+Integer.toString(cart.getUserId()), User.class);
        Product prod = tmp.getForObject("http://localhost:8080/api/db/products/"+Integer.toString(cart.getProductId()), Product.class);
        OrderObject ord = new OrderObject(user,prod);
        return ord;  
    }
    public void delete(int id){
        Cart order = orderDAO.findById(id).orElse(null);
        if(order != null){
            orderDAO.delete(order);
        }
    }
    public Cart update(int id, Cart newOrder){
        Cart order = orderDAO.findById(id).orElse(null);
        if (order != null){
            order.setProductId(newOrder.getProductId());
            order.setUserId(newOrder.getUserId());
        }
        return order;
    }
}
