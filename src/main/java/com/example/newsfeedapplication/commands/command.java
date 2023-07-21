package com.example.newsfeedapplication.commands;

import com.example.newsfeedapplication.exception.UserAlreadyExistException;
import com.example.newsfeedapplication.exception.UserNotfoundException;

public interface command {
    boolean match(String input);
    void execute(String input) throws UserAlreadyExistException, UserNotfoundException;
}
