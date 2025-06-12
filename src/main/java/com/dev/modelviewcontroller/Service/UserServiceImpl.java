package com.dev.modelviewcontroller.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.modelviewcontroller.Entity.UserTable;
import com.dev.modelviewcontroller.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
 @Autowired
 private UserRepository userRepository;

    @Override
    public boolean registeruser(UserTable user) {
        try{
            userRepository.save(user);
            return true;
        }  
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }    
          
    }

    @Override
    public UserTable loginUser(String email, String password) {
     UserTable validUser = userRepository.findByEmail(email);
      if(validUser != null && validUser.getPassword().equals(password))
      {
        return validUser;
      }

        return null;
    }

}
