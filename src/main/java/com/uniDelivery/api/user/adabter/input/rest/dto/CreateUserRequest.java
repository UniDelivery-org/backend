package com.uniDelivery.api.user.adabter.input.rest.dto;

import com.uniDelivery.api.shared.enums.UserRole;
import com.uniDelivery.api.shared.enums.VerificationStatus;

public record CreateUserRequest(
        String fullName,
        String email,
        String phone,
        String password,
        UserRole role,
        VerificationStatus verificationStatus,
        Boolean isOnline,
        Boolean isBlocked,
        Double currentLat,
        Double currentLon,
        String avatarUrl
) {
}
