package com.example.newsfeedapplication.repositories;

import com.example.newsfeedapplication.models.users;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<users,Long> {
    Optional<users> findByUsername(String username);

    users save(users user);


    }

