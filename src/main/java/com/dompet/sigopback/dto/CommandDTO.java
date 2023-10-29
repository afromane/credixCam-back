package com.dompet.sigopback.dto;

import com.dompet.sigopback.entity.Customer;
import com.dompet.sigopback.entity.Product;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CommandDTO {

    public Long id;

    public Integer quantity;

    public Date createdAt;

    public String status ;

    public Product product;

    public Customer customer;
}
