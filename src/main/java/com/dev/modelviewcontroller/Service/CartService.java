package com.dev.modelviewcontroller.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.modelviewcontroller.Entity.UserCart;

@Service
public interface CartService {
       public boolean addToCard(UserCart userCart);

List<UserCart> getAllItem();
}
