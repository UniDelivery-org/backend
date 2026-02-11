package com.uniDelivery.api.review.adabter.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
    List<Review> findByCourierId(UUID courierId);
    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.courier.id = :courierId")
    Double getAverageRatingForCourier(UUID courierId);
}