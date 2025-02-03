package com.example.ddd_project.aplication.usecase.user;

import org.springframework.stereotype.Service;
import com.example.ddd_project.domain.repository.UserRepository;

import com.example.ddd_project.aplication.usecase.UseCase;

import com.example.ddd_project.domain.model.User;
import com.example.ddd_project.domain.model.Address;

@Service
public class CreateUserUseCase implements UseCase<User, User> {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(User user) {
        User savedUser = new User(
                null,
                user.getName(),
                user.getEmail(),
                new Address(
                        null,
                        user.getAddress().getStreet(),
                        user.getAddress().getCity(),
                        user.getAddress().getZipCode()));

        userRepository.save(user);

        return savedUser;
    }

}
