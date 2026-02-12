package com.uniDelivery.api.user.adabter.output.persistence.repository;

import com.uniDelivery.api.shared.enums.UserRole;
import com.uniDelivery.api.shared.enums.VerificationStatus;
import com.uniDelivery.api.user.adabter.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    List<UserEntity> findByRoleAndVerificationStatus(UserRole role, VerificationStatus status);
}