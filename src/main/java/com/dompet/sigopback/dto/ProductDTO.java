package com.dompet.sigopback.dto;

import com.dompet.sigopback.entity.Catalog;
import com.dompet.sigopback.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

    public Long id;

    public String label;

    public String description;

    public String url;

    public String amount;

    public Boolean isActive ;

    public Catalog catalog;
}
