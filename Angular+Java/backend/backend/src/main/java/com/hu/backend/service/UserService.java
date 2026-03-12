package com.hu.backend.service;

import com.hu.backend.model.User;
import com.hu.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public List<User> searchUsers(String name)
    {
        return userRepository.findByNameContaining(name);
    }
}
