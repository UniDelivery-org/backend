package com.uniDelivery.api.delivery.adabter.output.repository;

import com.uniDelivery.api.delivery.adabter.output.entity.Delivery;
import com.uniDelivery.api.delivery.adabter.output.enums.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {

    List<Delivery> findByStatus(DeliveryStatus status);

    List<Delivery> findBySenderIdOrderByCreatedAtDesc(UUID senderId);

    List<Delivery> findByCourierIdOrderByCreatedAtDesc(UUID courierId);

    @Query("SELECT d FROM Delivery d WHERE d.courierId = :courierId AND d.status IN ('ACCEPTED', 'PICKED_UP', 'IN_TRANSIT')")
    List<Delivery> findActiveDeliveriesByCourier(UUID courierId);
}