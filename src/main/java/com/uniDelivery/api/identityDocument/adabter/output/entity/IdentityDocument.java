package com.uniDelivery.api.identityDocument.adabter.output.entity;

import com.uniDelivery.api.shared.entities.BaseEntity;
import com.uniDelivery.api.identityDocument.adabter.output.enums.IdentityDocType;
import com.uniDelivery.api.shared.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "identity_documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdentityDocument extends BaseEntity {
    @Column(name= "user_id", nullable = false)
    private UUID ownerId;

    @Enumerated(EnumType.STRING)
    private IdentityDocType type;

    private String documentNumber;
    private String fileUrl;

    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus = VerificationStatus.PENDING;

    private String rejectionReason;
    private Instant expiryDate;
    private Instant submittedAt;
}