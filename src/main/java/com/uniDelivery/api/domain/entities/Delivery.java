package com.uniDelivery.api.domain.entities;

import com.uniDelivery.api.domain.enums.*;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    private User courier;

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

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<TrackingLog> trackingLogs;
}