package com.dompet.sigopback.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CatalogDTO {
    public Long id;

    public String label;

    public Boolean isActive ;
}
