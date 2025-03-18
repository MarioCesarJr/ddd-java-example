package com.example.ddd_project.infra.core.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.ddd_project.domain.model.Address;
import com.example.ddd_project.domain.model.User;
import com.example.ddd_project.infra.entity.AddressEntity;
import com.example.ddd_project.infra.entity.UserEntity;
import com.example.ddd_project.infra.http.dto.AddressRequestDTO;
import com.example.ddd_project.infra.http.dto.AddressResponseDTO;
import com.example.ddd_project.infra.http.dto.UserRequestDTO;
import com.example.ddd_project.infra.http.dto.UserResponseDTO;
@Component
public class UserMapper {

    public static UserRequestDTO domainObjectToRequestDTO(User user) {

        List<AddressRequestDTO> addressRequestDTO = user.getAddresses().stream().map(address -> new AddressRequestDTO(address.getStreet(), address.getCity(), address.getZipCode())).collect(Collectors.toList());

        return new UserRequestDTO(user.getId(), user.getName(), user.getEmail(), addressRequestDTO);
    }
    
    public static UserResponseDTO domainObjectToResponseDTO(User user) {

        List<AddressResponseDTO> addressResponseDTO = user.getAddresses().stream()
                .map(address -> new AddressResponseDTO(address.getStreet(), address.getCity(), address.getZipCode()))
                .collect(Collectors.toList());

        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), addressResponseDTO);
    }

    public static User requestDTOToDomainObject(UserRequestDTO requestDTO) {

        List<Address> addresses = requestDTO.getAddresses().stream()
                .map(address -> new Address(null, address.getStreet(), address.getCity(), address.getZipCode()))
                .collect(Collectors.toList());

        return new User(requestDTO.getId(), requestDTO.getName(), requestDTO.getEmail(), addresses);
    }

    public static UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());

        // Mapeando os endereços
        List<AddressEntity> addressEntities = user.getAddresses().stream()
                .map(address -> {
                    AddressEntity addressEntity = new AddressEntity();
                    addressEntity.setStreet(address.getStreet());
                    addressEntity.setCity(address.getCity());
                    addressEntity.setZipCode(address.getZipCode());
                    addressEntity.setUser(userEntity);
                    return addressEntity;
                })
                .collect(Collectors.toList());

        userEntity.setAddresses(addressEntities);
        return userEntity;
    }

    public static User toDomain(UserEntity userEntity) {
        User user = new User(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
        for (AddressEntity addressEntity : userEntity.getAddresses()) {
            Address address = new Address(addressEntity.getId(), addressEntity.getStreet(), addressEntity.getCity(), addressEntity.getZipCode());
            user.addAddress(address);
        }
        return user;
    }
}
