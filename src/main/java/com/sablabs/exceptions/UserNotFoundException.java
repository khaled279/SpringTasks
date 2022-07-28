package com.sablabs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found")
@Getter
@Setter
public class UserNotFoundException extends RuntimeException {
    private HttpStatus httpStatus ; 
    private String message ;
}
