package com.dev.modelviewcontroller.Service;

import org.springframework.stereotype.Service;

import com.dev.modelviewcontroller.Entity.UserTable;

@Service
public interface UserService {
public boolean registeruser(UserTable userTable);
public UserTable loginUser(String email,String password);

}
