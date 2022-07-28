package com.sablabs.restapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sablabs.restapp.Entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    
}
