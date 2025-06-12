package com.dev.modelviewcontroller.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.modelviewcontroller.Entity.UserCart;
import com.dev.modelviewcontroller.repository.CartRepository;
@Service
public class CartServiceImpl implements CartService{
@Autowired
CartRepository cartRepository;
@Override
    public boolean addToCard(UserCart userCart) {
       try{
            cartRepository.save(userCart);
            return true;
        }
            catch(Exception e)
        {
            e.printStackTrace();
            return false;
        } 
        }

    @Override
    public List<UserCart> getAllItem() {
    return cartRepository.findAll();

    }

    } 
