package com.service.db.service;

import java.util.List;

import com.service.db.dao.ProductDAO;
import com.service.db.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> all(){
        return productDAO.findAll();
    }
    public Product getOne(Long id){
        return productDAO.findById(id).orElse(new Product());
    }
    public Product add(Product prod){
        return productDAO.save(prod);
    }
    public Product update(Long id, Product prod){
        Product p = productDAO.findById(id).orElse(null);
        p.setName(prod.getName());
        p.setCategory(prod.getCategory());
        p.setPrice(prod.getPrice());
        return productDAO.save(p);
    }
    
    public void delete(Long id){
        Product p = productDAO.findById(id).orElse(null);
        productDAO.delete(p);
    }
    
}
