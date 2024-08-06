package com.example.couplemaker.loveapi.repository;

import com.example.couplemaker.loveapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
