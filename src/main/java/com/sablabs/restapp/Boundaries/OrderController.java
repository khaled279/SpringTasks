package com.sablabs.restapp.Boundaries;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sablabs.restapp.Controllers.OrderService;
import com.sablabs.restapp.Controllers.UserService;
import com.sablabs.restapp.Entity.Order;
import com.sablabs.restapp.Entity.DtoModels.OrderDto;
import com.sablabs.restapp.repositories.OrderRepo;
import com.sablabs.restapp.repositories.UserRepo;

@RestController
@RequestMapping(path = "user" ,  method = {RequestMethod.GET, RequestMethod.PUT})
public class OrderController {
    @Autowired
    OrderRepo orderRepo; 
    @Autowired 
    OrderService orderService; 
    @Autowired 
    UserService userService; 
    @Autowired 
    UserRepo userRepo; 

    @GetMapping(value = "/{userId}/orders/{orderId}")
    public OrderDto getOrder(@PathVariable Integer userId , @PathVariable Integer orderId ){
        return orderService.getOrder(orderId); 
    }

    @GetMapping(value = "/{userId}/orders/getall")
    public List<OrderDto> getOrders(@PathVariable Integer userId){
        return orderService.getAllOrders(userId); 
    }

    @PostMapping(value = "/{userId}/orders/add")
    public OrderDto postAddOrder(@PathVariable Integer userId ,@RequestBody OrderDto order){
       return orderService.addOrder(order, userId); 
    }

}
