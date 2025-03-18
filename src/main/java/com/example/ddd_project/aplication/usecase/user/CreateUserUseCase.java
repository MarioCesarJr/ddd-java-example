package com.example.ddd_project.aplication.usecase.user;

import org.springframework.stereotype.Service;
import com.example.ddd_project.domain.repository.UserRepository;
import com.example.ddd_project.domain.service.Notification;
import com.example.ddd_project.aplication.usecase.UseCase;

import com.example.ddd_project.domain.model.User;
import com.example.ddd_project.domain.exception.DomainException;

@Service
public class CreateUserUseCase implements UseCase<User, User> {

    private final UserRepository userRepository;
    private final Notification notification;

    public CreateUserUseCase(UserRepository userRepository, Notification notification) {
        this.userRepository = userRepository;
        this.notification = notification;
    }

    @Override
    public User execute(User user) {

        if (user.getName().isEmpty() || user.getName() == null) {
            this.notification.addError("Nome é obrigatório.");
        }

        if (user.getEmail().isEmpty() || user.getEmail() == null) {
            this.notification.addError("E-mail é obrigatório.");
        }

        if (this.notification.hasErrors()) {
            throw new DomainException(this.notification);
        }

        User savedUser = new User(
                null,
                user.getName(),
                user.getEmail(),
                user.getAddresses());

        this.userRepository.save(user);

        return savedUser;
    }

}
