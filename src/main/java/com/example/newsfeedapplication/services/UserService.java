package com.example.newsfeedapplication.services;

import com.example.newsfeedapplication.exception.UserAlreadyExistException;
import com.example.newsfeedapplication.exception.UserNotfoundException;
import com.example.newsfeedapplication.models.UserStatus;
import com.example.newsfeedapplication.models.users;
import com.example.newsfeedapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    public UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public users signUpUser(String username,String password) throws UserAlreadyExistException {
        Optional<users> userOptional=userRepository.findByUsername(username);
        if(userOptional.isPresent()){
            if(userOptional.get().getUserStatus().equals(UserStatus.ACTIVE)){
                throw new UserAlreadyExistException();
            }
            else{
                users user=userOptional.get();
                user.setUserStatus(UserStatus.ACTIVE);
                user.setUsername(username);
                user.setPassword(password);
                return userRepository.save(user);
            }
        }
        users user=new users();

        user.setUsername(username);
        user.setPassword(password);
        user.setUserStatus(UserStatus.ACTIVE);


        return userRepository.save(user);
    }
    public Optional<users> loginUser(String username, String password)throws UserNotfoundException{
        Optional<users> user=userRepository.findByUsername(username);
        if(user.get().getUsername().equals(username)&&user.get().getPassword().equals(password)){
            return user;
        }

        return null;
    }

}
