package com.dompet.sigopback.repository;

import com.dompet.sigopback.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandRepository extends JpaRepository<Command, Long> {

    Optional<Command> findById(Long id);

}
