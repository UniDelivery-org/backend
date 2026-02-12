package com.uniDelivery.api.user.adabter.input.rest.dto;

public record AuthResponse(
        String accessToken,
        String refreshToken
) { }
