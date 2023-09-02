package com.blogapp.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.api.entities.User;


public interface UserRepository extends JpaRepository<User,Integer>{

}
