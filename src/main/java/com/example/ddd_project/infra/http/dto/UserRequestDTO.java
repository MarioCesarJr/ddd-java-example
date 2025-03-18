package com.example.ddd_project.infra.http.dto;

import java.util.List;

public class UserRequestDTO {
    private Long id;
    private String name;
    private String email;
    private List<AddressRequestDTO> addresses;

    public UserRequestDTO() {
    }

    public UserRequestDTO(Long id, String name, String email, List<AddressRequestDTO> addresses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addresses = addresses;
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

    public List<AddressRequestDTO> getAddresses() {
        return addresses;
    }

    public void setAddress(List<AddressRequestDTO> addresses) {
        this.addresses = addresses;
    }
}
