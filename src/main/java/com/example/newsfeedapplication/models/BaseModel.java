package com.example.newsfeedapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
}
