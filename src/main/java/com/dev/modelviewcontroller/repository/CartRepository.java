package com.dev.modelviewcontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.modelviewcontroller.Entity.UserCart;

@Repository
public interface CartRepository extends JpaRepository<UserCart, Integer> {


    public List<UserCart> findByUserId(int user);
    
}