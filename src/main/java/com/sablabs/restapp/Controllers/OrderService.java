package com.sablabs.restapp.Controllers;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.sablabs.exceptions.UserNotFoundException;
import com.sablabs.restapp.Entity.Order;
import com.sablabs.restapp.Entity.User;
import com.sablabs.restapp.Entity.DtoModels.OrderDto;
import com.sablabs.restapp.Entity.DtoModels.UserEditDto;
import com.sablabs.restapp.repositories.OrderRepo;
import com.sablabs.restapp.repositories.UserRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo ; 
    @Autowired 
    UserService userService; 
    @Autowired 
    ModelMapper modelMapper;
    @Autowired
    UserRepo userRepo; 

    public OrderDto addOrder(OrderDto orderDto , Integer userId){
        Order order = modelMapper.map(orderDto, Order.class) ; 
        User user = modelMapper.map(userService.getUser(userId) , User.class); 
        order.setUser(user);
        orderRepo.save(order); 
        // orderRepo.addOrder(orderDto.getTotal(), userId);
        return orderDto; 
    }

    public List<OrderDto> getAllOrders(Integer id){
        
       UserEditDto userEditDto =  userService.getUser(id); 
        
        return   orderRepo.findAll().stream()
        .filter(order -> order.getUser().getId()==id)
        .map(order-> { return modelMapper.map(order, OrderDto.class);})
        .collect(Collectors.toList()); 
    }

    public OrderDto getOrder(Integer id){
        Order order = orderRepo.findById(id).orElse(null); 
        if(order == null){
            throw new UserNotFoundException(); 
        }

        return modelMapper.map(order , OrderDto.class); 
    }


}
