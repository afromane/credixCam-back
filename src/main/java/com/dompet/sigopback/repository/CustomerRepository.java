package com.dompet.sigopback.repository;

import com.dompet.sigopback.entity.Command;
import com.dompet.sigopback.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long id);
}
