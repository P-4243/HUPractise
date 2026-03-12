package com.hu.backend.controller;

import com.hu.backend.model.User;
import com.hu.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User add(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getAll()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/search")
    public List<User> search(@RequestParam String name)
    {
        return userService.searchUsers(name);
    }

}
