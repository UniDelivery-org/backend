package com.uniDelivery.api.vehicleDocument.adabter.output.repository;

import com.uniDelivery.api.vehicleDocument.adabter.output.entity.VehicleDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VehicleDocumentRepository extends JpaRepository<VehicleDocument, UUID> {

    List<VehicleDocument> findByVehicleId(UUID vehicleId);
}