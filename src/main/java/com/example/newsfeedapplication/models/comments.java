package com.example.newsfeedapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class comments extends BaseModel{
private String commentId;
@ManyToOne
private users user;
private String description;
private int upvotes;
private int downvotes;
@ManyToOne
private posts post;
}
