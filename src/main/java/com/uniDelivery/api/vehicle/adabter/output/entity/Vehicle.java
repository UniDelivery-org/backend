package com.uniDelivery.api.vehicle.adabter.output.entity;

import com.uniDelivery.api.shared.entities.BaseEntity;
import com.uniDelivery.api.vehicleDocument.adabter.output.entity.VehicleDocument;
import com.uniDelivery.api.vehicle.adabter.output.enums.VehicleType;
import com.uniDelivery.api.shared.enums.VerificationStatus;
import com.uniDelivery.api.user.adabter.output.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private String model;
    private String plateNumber;
    private String color;

    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus = VerificationStatus.PENDING;

    private Boolean isActive = false;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<VehicleDocument> documents;
}