package com.dev.modelviewcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.modelviewcontroller.Entity.UserTable;


@Repository
public interface UserRepository extends JpaRepository<UserTable, Integer>{
UserTable findByEmail(String email);
}
