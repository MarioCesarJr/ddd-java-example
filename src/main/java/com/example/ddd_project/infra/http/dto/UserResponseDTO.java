package com.example.ddd_project.infra.http.dto;

import java.util.List;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<AddressResponseDTO> address;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String name, String email, List<AddressResponseDTO> address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AddressResponseDTO> getAddress() {
        return address;
    }

    public void setAddress(List<AddressResponseDTO> address) {
        this.address = address;
    }
}
