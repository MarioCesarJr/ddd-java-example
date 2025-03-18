package com.example.ddd_project.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class User {

    private Long id;

    private String name;
    private String email;

    private List<Address> addresses = new ArrayList<>();;

    public User() {
    }
    
    public User(Long id, String name, String email, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addresses = addresses;
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
