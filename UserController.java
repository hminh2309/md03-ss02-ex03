package com.example.ss02.exer02.controllers;

import com.example.ss02.exer02.models.User;
import com.example.ss02.exer02.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Lấy danh sách user, có hỗ trợ tìm kiếm gần đúng theo username
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String search) {
        List<User> allUsers = userService.findAllUsers();

        // Nếu không truyền tham số search thì trả về toàn bộ
        if (search == null || search.trim().isEmpty()) {
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        }

        // Lọc danh sách gần đúng bằng vòng lặp for
        List<User> filteredUsers = new ArrayList<>();
        for (User user : allUsers) {
            if (user.getUsername() != null && user.getUsername().toLowerCase().contains(search.toLowerCase())) {
                filteredUsers.add(user);
            }
        }

        return new ResponseEntity<>(filteredUsers, HttpStatus.OK);
    }
}