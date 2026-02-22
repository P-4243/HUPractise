package com.hu.backend.controller;

import com.hu.backend.dto.UserRequest;
import com.hu.backend.entity.User;
import com.hu.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 1️⃣ POST → Create → 201 Created
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest request)
    {
        User user=new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        User savedUser=userService.createUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // 2️⃣ GET → Fetch → 200 OK
    @GetMapping("/email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email)
    {

        User user=userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    // 3️⃣ SEARCH
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUserByName(@RequestParam String name)
    {
        return ResponseEntity.ok(userService.getUserByName(name));
    }
}
