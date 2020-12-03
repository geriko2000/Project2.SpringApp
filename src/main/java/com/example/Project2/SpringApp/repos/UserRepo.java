package com.example.Project2.SpringApp.repos;

import com.example.Project2.SpringApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String Username);

    User findByActivationCode(String code);
}
