package com.service.order.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.service.order.model.Cart;
import com.service.order.model.OrderObject;
import com.service.order.model.Product;
import com.service.order.model.User;
import com.service.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/orders")
public class OrderController{
    @Autowired
    private OrderService service;
    
    @PostMapping(value="")
    public Cart save(@RequestBody Cart order) {
        Cart saved = service.add(order);
        return saved;
    }
    @GetMapping("customer/{custid}")
    public List<Product> getDetails(@PathVariable("custid") int custid){
        return service.getByuser(custid);
    }
    @GetMapping("order/{id}")
    public String getOrder(@PathVariable("id") int id){
        return service.getOrder(id);
    }
    
}