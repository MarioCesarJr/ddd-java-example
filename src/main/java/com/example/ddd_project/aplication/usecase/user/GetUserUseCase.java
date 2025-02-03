package com.example.ddd_project.aplication.usecase.user;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.ddd_project.domain.repository.UserRepository;

import com.example.ddd_project.aplication.usecase.UseCase;

import com.example.ddd_project.domain.model.User;

@Service
public class GetUserUseCase implements UseCase<Long, Optional<User>> {

    private final UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> execute(Long id) {
        return userRepository.findById(id);
    }

}
