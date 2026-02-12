package com.uniDelivery.api.user.application.port.output;

import com.uniDelivery.api.shared.enums.UserRole;
import com.uniDelivery.api.shared.enums.VerificationStatus;
import com.uniDelivery.api.user.adabter.output.persistence.entity.UserEntity;
import com.uniDelivery.api.user.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    User save(User user);
    User findById(UUID id);
    void deleteById(UUID id);
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    List<User> findByRoleAndVerificationStatus(UserRole role, VerificationStatus status);
}
