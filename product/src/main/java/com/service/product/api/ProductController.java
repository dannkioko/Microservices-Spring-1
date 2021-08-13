package com.service.product.api;

import com.service.product.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/products")
public class ProductController{
    @Autowired
    private RestTemplate tmp;

    @GetMapping("{name}")
    public Product getProductsById(@PathVariable("name") int id){
        return tmp.getForObject("http://localhost:8080/api/db/products/"+Integer.toString(id), Product.class);
    }


}