package com.uniDelivery.api.vehicle.adabter.output.repository;

import com.uniDelivery.api.vehicle.adabter.output.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    List<Vehicle> findByOwnerId(UUID userId);
    Optional<Vehicle> findByOwnerIdAndIsActiveTrue(UUID userId);
}