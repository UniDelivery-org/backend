package com.uniDelivery.api.user.domain.model;

import com.uniDelivery.api.shared.enums.VerificationStatus;
import com.uniDelivery.api.shared.enums.UserRole;

import java.time.Instant;
import java.util.UUID;

public class User {

    private final UUID id;
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private UserRole role;
    private VerificationStatus verificationStatus = VerificationStatus.PENDING;
    private Boolean isOnline = false;
    private Boolean isBlocked = false;
    private Double currentLat;
    private Double currentLon;
    private String avatarUrl;
    private final Instant createdAt;
    private Instant updatedAt;

    public User(UUID id, String fullName, String email, String phone, String password, UserRole role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public void changePassword(String newPassword) {
        if (newPassword == null || newPassword.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        this.password = newPassword;
        touchUpdatedAt();
    }

    public void approve() {
        this.verificationStatus = VerificationStatus.APPROVED;
        touchUpdatedAt();
    }

    public void markPendingVerification() {
        this.verificationStatus = VerificationStatus.PENDING;
        touchUpdatedAt();
    }

    public void goOnline() {
        if (isBlocked) {
            throw new IllegalStateException("Blocked users cannot go online");
        }
        this.isOnline = true;
        touchUpdatedAt();
    }

    public void goOffline() {
        this.isOnline = false;
        touchUpdatedAt();
    }

    public void block() {
        this.isBlocked = true;
        this.isOnline = false;
        touchUpdatedAt();
    }

    public void unblock() {
        this.isBlocked = false;
        touchUpdatedAt();
    }

    public void updateLocation(Double lat, Double lon) {
        if (lat == null || lon == null) {
            throw new IllegalArgumentException("Latitude and longitude cannot be null");
        }
        this.currentLat = lat;
        this.currentLon = lon;
        touchUpdatedAt();
    }

    public void updateProfile(String fullName, String avatarUrl) {
        if (fullName != null && !fullName.isBlank()) {
            this.fullName = fullName;
        }
        if (avatarUrl != null && !avatarUrl.isBlank()) {
            this.avatarUrl = avatarUrl;
        }
        touchUpdatedAt();
    }

    private void touchUpdatedAt() {
        this.updatedAt = Instant.now();
    }

    public UUID getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public UserRole getRole() { return role; }
    public VerificationStatus getVerificationStatus() { return verificationStatus; }
    public Boolean getIsOnline() { return isOnline; }
    public Boolean getIsBlocked() { return isBlocked; }
    public Double getCurrentLat() { return currentLat; }
    public Double getCurrentLon() { return currentLon; }
    public String getAvatarUrl() { return avatarUrl; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }

    public boolean canGoOnline() {
        return !isBlocked;
    }

    public boolean isApproved() {
        return verificationStatus == VerificationStatus.APPROVED;
    }

    public boolean isAdmin() {
        return role == UserRole.ADMIN;
    }
}

