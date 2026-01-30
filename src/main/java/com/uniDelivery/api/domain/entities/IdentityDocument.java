package com.uniDelivery.api.domain.entities;

import com.uniDelivery.api.domain.enums.IdentityDocType;
import com.uniDelivery.api.domain.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Table(name = "identity_documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdentityDocument extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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