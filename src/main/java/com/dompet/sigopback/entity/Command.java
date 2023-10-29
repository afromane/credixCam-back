package com.dompet.sigopback.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Data
@NoArgsConstructor
@Transactional
@Entity
@Table(name= "command")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Integer quantity;

    public Date createdAt;

    public String status ;

    @ManyToOne
    public Product product;

    @ManyToOne
    public Customer customer;


}
