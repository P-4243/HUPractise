package com.hu.backend.repository;

import com.hu.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    List<User> findByNameContaining(String keyword);

//    It is NOT SQL.-It is JPQL parameter binding.
    @Query("select u from User u where u.email like %:domain%")
    List<User> findUserByEmailDomain(@Param("domain") String domain);
//    Derived Query Method-Spring builds query based on method name.
//    @Query → Custom JPQL or native SQL when logic is complex

}
