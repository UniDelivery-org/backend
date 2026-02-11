package com.uniDelivery.api.user.adabter.output.repository;

import com.uniDelivery.api.user.adabter.output.enums.UserRole;
import com.uniDelivery.api.shared.enums.VerificationStatus;
import com.uniDelivery.api.user.adabter.output.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    List<User> findByRoleAndVerificationStatus(UserRole role, VerificationStatus status);
}