package com.example.ddd_project.infra;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ddd_project.domain.model.User;
import com.example.ddd_project.domain.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findById(Long id) {
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Transactional
    @Override
    public User save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        
        return user;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        User user = entityManager.find(User.class, id);

        if (user == null) {
            throw new EntityNotFoundException("User not found id: " + id);
        }
        
        entityManager.remove(user); 
    }
}
