package com.dompet.sigopback.repository;

import com.dompet.sigopback.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

        Optional<Product> findById(Long id);
}
