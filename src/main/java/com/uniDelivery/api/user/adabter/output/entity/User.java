package com.uniDelivery.api.user.adabter.output.entity;

import com.uniDelivery.api.shared.entities.BaseEntity;
import com.uniDelivery.api.identityDocument.adabter.output.entity.IdentityDocument;
import com.uniDelivery.api.vehicle.adabter.output.entity.Vehicle;
import com.uniDelivery.api.wallet.adabter.output.entity.Wallet;
import com.uniDelivery.api.user.adabter.output.enums.UserRole;
import com.uniDelivery.api.shared.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VerificationStatus verificationStatus = VerificationStatus.PENDING;

    private Boolean isOnline = false;
    private Boolean isBlocked = false;

    private Double currentLat;
    private Double currentLon;

    private String avatarUrl;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Wallet wallet;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<IdentityDocument> identityDocuments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "courier", cascade = CascadeType.ALL)
    private List<Review> reviewsReceived;
}