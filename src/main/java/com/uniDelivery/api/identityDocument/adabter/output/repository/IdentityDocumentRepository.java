package com.uniDelivery.api.identityDocument.adabter.output.repository;

import com.uniDelivery.api.identityDocument.adabter.output.entity.IdentityDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IdentityDocumentRepository extends JpaRepository<IdentityDocument, UUID> {
    List<IdentityDocument> findByUserId(UUID userId);
}