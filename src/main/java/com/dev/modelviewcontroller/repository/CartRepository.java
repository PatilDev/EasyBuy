package com.dev.modelviewcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.modelviewcontroller.Entity.UserCart;

@Repository
public interface CartRepository extends JpaRepository<UserCart, Integer> {
    
}