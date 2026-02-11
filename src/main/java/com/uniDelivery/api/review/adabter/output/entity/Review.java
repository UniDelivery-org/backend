package com.uniDelivery.api.review.adabter.output.entity;

import com.uniDelivery.api.shared.entities.BaseEntity;
import com.uniDelivery.api.delivery.adabter.output.entity.Delivery;
import com.uniDelivery.api.user.adabter.output.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id", nullable = false, unique = true)
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id", nullable = false)
    private User courier;

    @Column(nullable = false)
    private Integer rating;

    @Column(length = 500)
    private String comment;
}