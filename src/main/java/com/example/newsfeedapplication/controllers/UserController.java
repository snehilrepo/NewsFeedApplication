package com.example.newsfeedapplication.controllers;

import com.example.newsfeedapplication.dtos.LoginUserRequestDto;
import com.example.newsfeedapplication.dtos.LoginUserResponseDto;
import com.example.newsfeedapplication.dtos.SignUpUserRequestDto;
import com.example.newsfeedapplication.dtos.SignUpUserResponseDto;
import com.example.newsfeedapplication.exception.UserAlreadyExistException;
import com.example.newsfeedapplication.exception.UserNotfoundException;
import com.example.newsfeedapplication.models.users;
import com.example.newsfeedapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserController {
    public UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    public SignUpUserResponseDto signUpUser(SignUpUserRequestDto request) throws UserAlreadyExistException {
        users user;
        SignUpUserResponseDto response = new SignUpUserResponseDto();
        try {
            user = userService.signUpUser(request.getUsername(), request.getPassword());
            response.setUserId(user.getId());
            response.setStatus("SUCCESS");
        } catch (UserAlreadyExistException userAlreadyExistException) {
            response.setStatus("FAILURE");
            response.setMessage(userAlreadyExistException.getMessage());
        }
        return response;
    }

    public LoginUserResponseDto loginUser(LoginUserRequestDto request) throws UserNotfoundException {
        LoginUserResponseDto response = new LoginUserResponseDto();
            Optional<users> user=userService.loginUser(request.getUsername(),request.getPassword());
        if(user.isPresent()){
            response.setStatus("SUCCESS");
        }
        else{
            response.setStatus("Invalid");
        }
        return response;
}
}
