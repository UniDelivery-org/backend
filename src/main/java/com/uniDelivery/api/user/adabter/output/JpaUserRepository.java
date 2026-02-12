package com.uniDelivery.api.user.adabter.output;

import com.uniDelivery.api.shared.enums.UserRole;
import com.uniDelivery.api.shared.enums.VerificationStatus;
import com.uniDelivery.api.user.adabter.output.persistence.mapper.UserMapper;
import com.uniDelivery.api.user.adabter.output.persistence.repository.UserRepository;
import com.uniDelivery.api.user.application.port.output.UserRepositoryPort;
import com.uniDelivery.api.user.domain.model.User;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class JpaUserRepository implements UserRepositoryPort {
    private UserRepository repository;
    private UserMapper mapper;
    @Override
    public User save(User user) {
        return mapper.toDomain(repository.save(mapper.toEntity(user)));
    }

    @Override
    public User findById(UUID id) {
        return mapper.toDomain(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.of(mapper.toDomain(repository.findByEmail(email).orElseThrow(EntityNotFoundException::new)));
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return repository.existsByPhone(phone);
    }

    @Override
    public List<User> findByRoleAndVerificationStatus(UserRole role, VerificationStatus status) {
        return repository.findAll().stream().map(userEntity -> mapper.toDomain(userEntity)).toList();
    }
}
