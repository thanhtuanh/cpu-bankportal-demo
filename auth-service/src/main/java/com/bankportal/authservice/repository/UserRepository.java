package com.bankportal.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankportal.authservice.model.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
