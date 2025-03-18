package com.example.ddd_project.infra.http.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ddd_project.aplication.usecase.user.CreateUserUseCase;
import com.example.ddd_project.aplication.usecase.user.DeleteUserUseCase;
import com.example.ddd_project.aplication.usecase.user.GetUserUseCase;
import com.example.ddd_project.domain.exception.DomainException;
import com.example.ddd_project.infra.core.mapper.UserMapper;
import com.example.ddd_project.infra.http.dto.UserRequestDTO;
import com.example.ddd_project.infra.http.dto.UserResponseDTO;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final CreateUserUseCase createUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final GetUserUseCase getUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, DeleteUserUseCase deleteUserUseCase, GetUserUseCase getUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> store(@RequestBody UserRequestDTO userDTO) {

        try {
            this.createUserUseCase.execute(UserMapper.requestDTOToDomainObject(userDTO));
            return new ResponseEntity<>(HttpStatus.CREATED);   
        } catch (DomainException e) {
            return new ResponseEntity<>(e.getNotification().getErrorResponse(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> show(@PathVariable Long id) {
        return new ResponseEntity<>(UserMapper.domainObjectToResponseDTO(
                getUserUseCase.execute(id).get()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        
        try {
            deleteUserUseCase.execute(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
