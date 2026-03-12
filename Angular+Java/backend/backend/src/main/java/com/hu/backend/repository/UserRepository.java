package com.hu.backend.repository;

import com.hu.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{
    List<User> findByNameContaining(String name);
}
