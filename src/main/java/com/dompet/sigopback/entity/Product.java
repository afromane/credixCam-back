package com.dompet.sigopback.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Data
@NoArgsConstructor
@Transactional
@Entity
@Table(name= "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String label;

    public String description;

    public String url;

    public String amount;

    public Boolean isActive = true;

    @ManyToOne
    public Catalog catalog;

    @ManyToOne
    public User user;

}
