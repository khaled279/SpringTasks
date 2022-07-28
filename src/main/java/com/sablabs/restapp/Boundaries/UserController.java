package com.sablabs.restapp.Boundaries;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;
import com.sablabs.exceptions.UserNotFoundException;
import com.sablabs.restapp.Controllers.UserService;
import com.sablabs.restapp.Entity.DtoModels.UserEditDto;



@RestController
@RequestMapping(path = "demo")
public class UserController  {
    @Autowired
    UserService userService;
    @GetMapping("/getUsers")
    public @ResponseBody java.util.List<UserEditDto> getAllUser(){
        return userService.getAllUsers();  
    }

    @PostMapping("/add")
    public  UserEditDto addNewUser(@RequestBody UserEditDto userEditDto){ 
        return userService.postAddUser(userEditDto); 
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity< UserEditDto> removeUser(@PathVariable Integer id){
        return ResponseEntity.ok(userService.deleteUser(id)); 
    }

    @PutMapping("/update")
    public ResponseEntity<UserEditDto> updateUser(@RequestBody UserEditDto userDto) throws UserNotFoundException
    {
        return ResponseEntity.ok(userService.editUser(userDto)); 
    }

}
