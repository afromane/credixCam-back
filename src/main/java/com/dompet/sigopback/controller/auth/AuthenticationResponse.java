package com.dompet.sigopback.controller.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    public String accessToken ;
    public String refreshToken;
    public Date expiration ;
    public String role;
    public String email;

}

