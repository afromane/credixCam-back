package com.dompet.sigopback.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    public Long id;

    private String password;
    private String username;
    private String email;
    private Boolean isActive = true;
}
