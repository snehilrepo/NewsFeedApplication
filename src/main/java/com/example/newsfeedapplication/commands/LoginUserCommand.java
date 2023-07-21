package com.example.newsfeedapplication.commands;

import com.example.newsfeedapplication.controllers.UserController;
import com.example.newsfeedapplication.dtos.LoginUserRequestDto;
import com.example.newsfeedapplication.exception.UserAlreadyExistException;
import com.example.newsfeedapplication.exception.UserNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class LoginUserCommand implements command {
    private UserController userController;
@Autowired
    public LoginUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean match(String input) {
        List<String> input_words = Arrays.stream(input.split(" ")).toList();
        if (input_words.size() == 3 && input_words.get(0).equalsIgnoreCase(commandKeyword.LOGIN_USER)) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) throws UserAlreadyExistException, UserNotfoundException {
        List<String> input_words = Arrays.stream(input.split(" ")).toList();
        String username = input_words.get(1);
        String password = input_words.get(2);

        //now call controller
        LoginUserRequestDto request = new LoginUserRequestDto();
        request.setUsername(username);
        request.setPassword(password);
        userController.loginUser(request);

    }

        }

