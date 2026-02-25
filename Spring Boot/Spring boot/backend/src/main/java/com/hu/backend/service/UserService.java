package com.hu.backend.service;

import com.hu.backend.dto.UserRequest;
import com.hu.backend.entity.User;
import com.hu.backend.exception.UserNotFoundException;
import com.hu.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    public User getUserByEmail(String email)
    {
        return userRepository.findByEmail(email)
                .orElseThrow(()->new UserNotFoundException("user with email: "+email+"is not found"));
    }

    public List<User> getUserByName(String name)
    {
        return userRepository.findByNameContaining(name);
    }

    public List<User> searchUserByDomain(String domain)
    {
        return userRepository.findUserByEmailDomain(domain);
    }

    public User updateUser(Long id, UserRequest request)
    {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + id)
                );
        existingUser.setName(request.getName());
        existingUser.setEmail(request.getEmail());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id)
    {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + id)
                );
        userRepository.delete(existingUser);
    }
}

