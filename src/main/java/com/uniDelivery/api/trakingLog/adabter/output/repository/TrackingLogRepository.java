package com.uniDelivery.api.trakingLog.adabter.output.repository;

import com.uniDelivery.api.trakingLog.adabter.output.entity.TrackingLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrackingLogRepository extends JpaRepository<TrackingLog, UUID> {
    List<TrackingLog> findByDeliveryIdOrderByTimestampAsc(UUID deliveryId);
}