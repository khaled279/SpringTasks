package com.sablabs.restapp.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.event.spi.PreUpdateEvent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sablabs.exceptions.UserNotFoundException;
import com.sablabs.restapp.Entity.User;
import com.sablabs.restapp.Entity.DtoModels.UserEditDto;
import com.sablabs.restapp.repositories.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo ; 
    @Autowired
    private ModelMapper modelMapper; 
    
    public List<UserEditDto> getAllUsers(){
        return userRepo.findAll().stream()
        .map(user->{return modelMapper.map(user, UserEditDto.class)  ;})
        .collect(Collectors.toList()) ;  
    }
    public UserEditDto postAddUser(UserEditDto userEditDto){
        User user = modelMapper.map(userEditDto, User.class); 
        userRepo.save(user);
        return userEditDto; 
    }
    public UserEditDto deleteUser(Integer id){
        User user = userRepo.findById(id).orElse(null);  
        if(user==null){
            throw new UserNotFoundException(); 
            // return ResponseEntity.notFound().build();
        }
        userRepo.delete(user);
        return modelMapper.map(user, UserEditDto.class); 
    }
    
    public UserEditDto editUser(UserEditDto userDto){
        User updatUser = userRepo.findById(userDto.getId()).orElse(null); 
        if(updatUser ==null){
            throw new UserNotFoundException();
        }
        updatUser.setName(userDto.getName());
        userRepo.save(updatUser); 
        return userDto; 
    }

    public UserEditDto getUser(Integer id){
        User user = userRepo.findById(id).orElse(null);  
        if(user==null){
            throw new UserNotFoundException(); 
            // return ResponseEntity.notFound().build();
        }
        return modelMapper.map(user, UserEditDto.class); 
    }
    public void saveUser(User user){
        userRepo.save(user); 
    }


}

