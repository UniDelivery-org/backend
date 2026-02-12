package com.uniDelivery.api.review.adabter.output.entity;

import com.uniDelivery.api.shared.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review extends BaseEntity {
    @Column(nullable = false)
    private UUID deliveryId;
    @Column(nullable = false)
    private UUID courierId;

    @Column(nullable = false)
    private Integer rating;

    @Column(length = 500)
    private String comment;
}