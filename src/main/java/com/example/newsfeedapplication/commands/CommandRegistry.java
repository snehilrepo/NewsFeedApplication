package com.example.newsfeedapplication.commands;

import com.example.newsfeedapplication.exception.UserAlreadyExistException;
import com.example.newsfeedapplication.exception.UserNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CommandRegistry {
 private List<command> commands;
 @Autowired
 public CommandRegistry(SignUpUserCommand signUpUserCommand){
     commands=new ArrayList<>();
     commands.add(signUpUserCommand);
 }
 public void execute(String input) throws UserAlreadyExistException, UserNotfoundException {
     for(command command:commands){
        if(command.match(input)){
           command.execute(input);
           break;
        }

     }

 }

}
