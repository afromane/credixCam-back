package com.dompet.sigopback.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO {
    public Long id;

    public String firstName;

    public String lastName;

    public String phone;
}
