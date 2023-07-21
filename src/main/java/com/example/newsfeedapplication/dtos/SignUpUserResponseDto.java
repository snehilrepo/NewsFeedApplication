package com.example.newsfeedapplication.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class SignUpUserResponseDto {
    private Long userId;
    private String Status;
    private String message;

}
