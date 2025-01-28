package com.example.ddd_project.domain.repository;

import java.util.Optional;

import com.example.ddd_project.domain.model.*;

public interface UserRepository {
    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);
}
