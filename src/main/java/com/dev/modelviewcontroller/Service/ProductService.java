package com.dev.modelviewcontroller.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.modelviewcontroller.Entity.Product;
@Service
public interface ProductService {
    public boolean addproduct(Product product);
    public List<Product> getAllProducts();
     public Product getProductById(int id);
     public List<Product> findByName(String name);

    
}
