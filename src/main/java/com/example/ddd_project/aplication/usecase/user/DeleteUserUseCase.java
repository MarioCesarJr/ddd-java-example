package com.example.ddd_project.aplication.usecase.user;

import org.springframework.stereotype.Service;
import com.example.ddd_project.domain.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

import com.example.ddd_project.aplication.usecase.UseCase;

import com.example.ddd_project.domain.model.User;

@Service
public class DeleteUserUseCase implements UseCase<Long, User> {

    private final UserRepository userRepository;

    public DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("User not found id: " + id);
        }

        return null;
    }

}
