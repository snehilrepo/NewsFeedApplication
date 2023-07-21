package com.example.newsfeedapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUserRequestDto {
    private String username;
    private String password;
}
