package com.example.newsfeedapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class posts extends BaseModel{
       private String postId;
       @ManyToOne
       private users user;
       private String postDescription;

       private int upvotes;
       private int downvotes;
       @OneToMany
       private List<comments> commentsList;
}
