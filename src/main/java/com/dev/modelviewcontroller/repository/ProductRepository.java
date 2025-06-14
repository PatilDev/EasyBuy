package com.dev.modelviewcontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.modelviewcontroller.Entity.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product,Integer> {



    public List<Product> findByProductType(String productType);
    public List<Product> findByProductName(String productName);

}
