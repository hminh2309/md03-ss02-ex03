package com.example.ss02.exer02.repositories;

import com.example.ss02.exer02.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1L, "nguyenvana", "vana@gmail.com", "ADMIN"));
        users.add(new User(2L, "tranthib", "thib@gmail.com", "USER"));
        users.add(new User(3L, "lethic", "thic@gmail.com", "USER"));
    }

    public List<User> findAll() {
        return users;
    }
}