package com.service.db.api;

import java.util.List;

import com.service.db.model.Product;
import com.service.db.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/db/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public void add(@RequestBody Product prod){
        productService.add(prod);
    }
    @GetMapping
    public List<Product> all(){
        return productService.all();
    }
    @GetMapping("{id}")
    public Product one(@PathVariable("id") Long id){
        return productService.getOne(id);
    }
    @PutMapping("{id}")
    public Product update(@PathVariable("id") Long id, @RequestBody Product prod){
        return productService.update(id, prod);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }
}
