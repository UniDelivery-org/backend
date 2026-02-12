package com.uniDelivery.api.vehicle.adabter.output.entity;

import com.uniDelivery.api.shared.entities.BaseEntity;
import com.uniDelivery.api.vehicle.adabter.output.enums.VehicleType;
import com.uniDelivery.api.shared.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends BaseEntity {
    @Column(name= "user_id", nullable = false)
    private UUID ownerId; // user who has this vehicle

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private String model;
    private String plateNumber;
    private String color;

    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus = VerificationStatus.PENDING;

    private Boolean isActive = false;
}