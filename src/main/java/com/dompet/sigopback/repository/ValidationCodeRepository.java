package com.dompet.sigopback.repository;

import com.dompet.sigopback.entity.ValidationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValidationCodeRepository extends JpaRepository<ValidationCode, Integer> {

    Optional<ValidationCode> findByCode(String code);
}
