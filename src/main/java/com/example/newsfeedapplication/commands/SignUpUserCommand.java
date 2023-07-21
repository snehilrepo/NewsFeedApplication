package com.example.newsfeedapplication.commands;

import com.example.newsfeedapplication.controllers.UserController;
import com.example.newsfeedapplication.dtos.SignUpUserRequestDto;
import com.example.newsfeedapplication.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class SignUpUserCommand implements command {
    private UserController userController;
    @Autowired
    public SignUpUserCommand(UserController userController){
        this.userController=userController;
    }
    @Override
    public boolean match(String input) {
      List<String> input_words= Arrays.stream(input.split(" ")).toList();
     if(input_words.size()==3 && input_words.get(0).equalsIgnoreCase(commandKeyword.SIGN_UP_USER)){
          return true;
        }
     return false;
    }

    @Override
    public void execute(String input) throws UserAlreadyExistException {
   List<String> input_words=Arrays.stream(input.split(" ")).toList();
   String username=input_words.get(1);
   String password=input_words.get(2);
  //Now call user controller


        SignUpUserRequestDto request=new SignUpUserRequestDto();
        request.setPassword(password);
        request.setUsername(username);

        userController.signUpUser(request);
    }
}
