package com.uniDelivery.api.wallet.adabter.output.entity;

import com.uniDelivery.api.shared.entities.BaseEntity;
import com.uniDelivery.api.transaction.adabter.output.entity.Transaction;
import com.uniDelivery.api.user.adabter.output.entity.User;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "wallets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wallet extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal frozenAmount = BigDecimal.ZERO;

    // The amount the courier owes the platform (Commission from COD)
    @Column(nullable = false)
    private BigDecimal commissionDebt = BigDecimal.ZERO;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}