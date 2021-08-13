package com.service.order.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.service.order.model.Cart;
import com.service.order.model.OrderObject;
import com.service.order.model.Product;
import com.service.order.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping(value = "")
    public OrderObject saveOrders(@RequestBody Cart order) {
        return service.add(order);
    }

    @GetMapping
    public List<OrderObject> getOrders() {
        return service.all();
    }

    @GetMapping("customer/{custid}")
    public List<Product> getDetails(@PathVariable("custid") int custid) {
        return service.getByuser(custid);
    }

    @GetMapping("order/{id}")
    public OrderObject getOrder(@PathVariable("id") int id) {
        return service.getOrder(id);
    }

    @PutMapping("order/{id}")
    public Cart updateOrder(@PathVariable("id") int id, @RequestBody Cart order) {
        return service.update(id, order);
    }

    @DeleteMapping("order/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        service.delete(id);
    }

}