package com.example.ddd_project.infra.core.mapper;

import org.springframework.stereotype.Component;

import com.example.ddd_project.domain.model.Address;
import com.example.ddd_project.domain.model.User;
import com.example.ddd_project.web.dto.AddressRequestDTO;
import com.example.ddd_project.web.dto.UserRequestDTO;
import com.example.ddd_project.web.dto.UserResponseDTO;

@Component
public class UserMapper {

    public UserRequestDTO domainObjectToRequestDTO(User user) {
        return new UserRequestDTO(user.getId(), user.getName(), user.getEmail(), new AddressRequestDTO(
                user.getAddress().getStreet(), user.getAddress().getCity(), user.getAddress().getZipCode()));
    }
    
    public UserResponseDTO domainObjectToResponseDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), new AddressRequestDTO(
                user.getAddress().getStreet(), user.getAddress().getCity(), user.getAddress().getZipCode()));
    }

    public User requestDTOToDomainObject(UserRequestDTO requestDTO) {
        return new User(requestDTO.getId(), requestDTO.getName(), requestDTO.getEmail(), new Address(null, requestDTO.getAddress().getStreet(), requestDTO.getAddress().getCity(), requestDTO.getAddress().getZipCode()));
    }
}
