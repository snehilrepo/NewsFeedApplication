package com.example.newsfeedapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpUserRequestDto {
  private String username;
  private String password;
}
