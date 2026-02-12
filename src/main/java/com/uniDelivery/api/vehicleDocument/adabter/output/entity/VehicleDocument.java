package com.uniDelivery.api.vehicleDocument.adabter.output.entity;

import com.uniDelivery.api.shared.entities.BaseEntity;
import com.uniDelivery.api.vehicleDocument.adabter.output.enums.VehicleDocType;
import com.uniDelivery.api.shared.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "vehicle_documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDocument extends BaseEntity {
    @Column(nullable = false)
    private UUID vehicleId;

    @Enumerated(EnumType.STRING)
    private VehicleDocType type;

    private String fileUrl;

    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus = VerificationStatus.PENDING;

    private Instant expiryDate;
}