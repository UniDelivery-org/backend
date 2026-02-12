package com.uniDelivery.api.delivery.adabter.output.entity;

import com.uniDelivery.api.delivery.adabter.output.enums.DeliveryStatus;
import com.uniDelivery.api.delivery.adabter.output.enums.PayerType;
import com.uniDelivery.api.delivery.adabter.output.enums.PaymentMethod;
import com.uniDelivery.api.shared.entities.BaseEntity;
import com.uniDelivery.api.vehicle.adabter.output.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Delivery extends BaseEntity {
    @Column(nullable = false)
    private UUID senderId;
    private UUID courierId;

    private String pickupAddress;
    private Double pickupLat;
    private Double pickupLon;

    private String dropoffAddress;
    private Double dropoffLat;
    private Double dropoffLon;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status = DeliveryStatus.PENDING;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleTypeRequired;

    private Double weightKg;
    private Double distanceKm;
    private String note;

    private String receiverName;
    private String receiverPhone;

    private BigDecimal agreedPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private PayerType payerType;

    private Instant completedAt;
}