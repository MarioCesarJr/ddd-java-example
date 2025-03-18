package com.example.ddd_project.infra.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ddd_project.domain.model.User;
import com.example.ddd_project.domain.repository.UserRepository;
import com.example.ddd_project.infra.core.mapper.UserMapper;
import com.example.ddd_project.infra.entity.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findById(Long id) {

        UserEntity userEntity = entityManager.find(UserEntity.class, id);
        return Optional.ofNullable(UserMapper.toDomain(userEntity));
    }

    @Transactional
    @Override
    public User save(User user) {

        UserEntity userEntity = UserMapper.toEntity(user);

        if (user.getId() == null) {
            entityManager.persist(userEntity);
        } else {
            entityManager.merge(userEntity);
        }

        return UserMapper.toDomain(userEntity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        UserEntity userEntity = entityManager.find(UserEntity.class, id);
       
        if (userEntity == null) {
            throw new EntityNotFoundException("User not found id: " + id);
        }
        
        entityManager.remove(userEntity); 
    }
}
