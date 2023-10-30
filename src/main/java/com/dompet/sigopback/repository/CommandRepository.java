package com.dompet.sigopback.repository;

import com.dompet.sigopback.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {

    Optional<Command> findById(Long id);

}
