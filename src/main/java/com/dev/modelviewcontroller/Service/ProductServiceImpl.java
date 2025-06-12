package com.dev.modelviewcontroller.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.modelviewcontroller.Entity.Product;
import com.dev.modelviewcontroller.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    public ProductRepository productRepository;

    @Override
    public boolean addproduct(Product product) {
        try{
            productRepository.save(product);
            return true;
        }
            catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }     

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);}
    public List<Product> findByName(String name)
    {
        return productRepository.findByProductName(name);
    }
}
