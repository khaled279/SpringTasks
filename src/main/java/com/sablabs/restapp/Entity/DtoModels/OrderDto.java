package com.sablabs.restapp.Entity.DtoModels;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sablabs.restapp.Entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private Integer id; 
    private Integer total; 
    @JsonIgnore
    private User user ; 
}
