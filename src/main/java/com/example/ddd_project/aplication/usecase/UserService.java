package com.example.ddd_project.aplication.usecase;

import org.springframework.stereotype.Service;
import com.example.ddd_project.domain.repository.UserRepository;
import com.example.ddd_project.domain.model.User;
import com.example.ddd_project.domain.model.Address;
import com.example.ddd_project.presentation.rest.*;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        
        User user = new User(
                null,
                userDTO.getName(),
                userDTO.getEmail(),
                new Address(
                        null,
                        userDTO.getAddress().getStreet(),
                        userDTO.getAddress().getCity(),
                        userDTO.getAddress().getZipCode()));

        
        User savedUser = userRepository.save(user);

        return new UserDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                new AddressDTO(
                        savedUser.getAddress().getStreet(),
                        savedUser.getAddress().getCity(),
                        savedUser.getAddress().getZipCode()));
    }

    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        new AddressDTO(
                                user.getAddress().getStreet(),
                                user.getAddress().getCity(),
                                user.getAddress().getZipCode())))
                .orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
