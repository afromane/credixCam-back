package com.dompet.sigopback.repository;

import com.dompet.sigopback.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
    Optional<Catalog> findByLabel(String label);
}
