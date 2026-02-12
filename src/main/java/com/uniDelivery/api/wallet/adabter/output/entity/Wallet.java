package com.uniDelivery.api.wallet.adabter.output.entity;

import com.uniDelivery.api.shared.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "wallets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wallet extends BaseEntity {
    @Column(name= "user_id", nullable = false)
    private UUID ownerId;

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal frozenAmount = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal commissionDebt = BigDecimal.ZERO;
}