package com.sablabs.restapp.Entity.DtoModels;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sablabs.restapp.Entity.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEditDto {

    Integer id; 
    String name ;
    Set<Order> orders ; 
    
    @JsonIgnore
    LocalDateTime editedAt = LocalDateTime.now(); 

    @JsonIgnore
    LocalDateTime createdAt = LocalDateTime.now() ; 

}
