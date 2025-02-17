package com.example.ddd_project.web.dto;

public class UserRequestDTO {
    private Long id;
    private String name;
    private String email;
    private AddressRequestDTO address;

    public UserRequestDTO() {
    }

    public UserRequestDTO(Long id, String name, String email, AddressRequestDTO address) {
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

    public AddressRequestDTO getAddress() {
        return address;
    }

    public void setAddress(AddressRequestDTO address) {
        this.address = address;
    }
}
