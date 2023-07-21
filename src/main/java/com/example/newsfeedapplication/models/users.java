package com.example.newsfeedapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;
@Getter
@Setter
@Entity
public class users extends BaseModel{
    private String username;
    private String password;
    @OneToMany
    List<posts> feeds;
    @OneToMany
    List<users> followers;
    @OneToMany
    List<users> following;
    UserStatus userStatus;

}
