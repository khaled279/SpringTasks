package com.sablabs.restapp.AOP;

import javax.persistence.EntityNotFoundException;

import org.apache.catalina.connector.Response;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sablabs.exceptions.UserNotFoundException;

@Aspect
@Configuration
@ControllerAdvice
public class userNotFoundAop extends ResponseEntityExceptionHandler{
    @ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleUserNotFoundException(EntityNotFoundException e){
        UserNotFoundException userNotFoundException = new UserNotFoundException(); 
        userNotFoundException.setHttpStatus(HttpStatus.NOT_FOUND);
        userNotFoundException.setMessage(e.getMessage());
        return new ResponseEntity<>(userNotFoundException,userNotFoundException.getHttpStatus()); 
        
    }
}
