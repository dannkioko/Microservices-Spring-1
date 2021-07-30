package com.service.db.service;

import java.util.ArrayList;
import java.util.List;

import com.service.db.dao.ProductDAO;
import com.service.db.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public List<Product> all(){
        return productDAO.findAll();
    }
    public Product getOne(int id){
        return productDAO.getById(id);
    }
    public Product add(Product prod){
        return productDAO.save(prod);
    }
    
}
