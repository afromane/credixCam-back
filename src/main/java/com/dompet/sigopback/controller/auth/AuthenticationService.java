package com.dompet.sigopback.controller.auth;

import com.dompet.sigopback.dto.AuthentificationDTO;
import com.dompet.sigopback.repository.UserRepository;
import com.dompet.sigopback.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    public  final AuthenticationManager authenticationManager;

    public  AuthenticationResponse authenticate(AuthentificationDTO authentificationDTO){
        final Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentificationDTO.getUsername(), authentificationDTO.getPassword())
        );

        if(authenticate.isAuthenticated()) {
            var user = this.userRepository.findByEmail(authentificationDTO.getUsername())
                    .orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            var jwtRefreshToken = jwtService.generateRefreshToken(user);
            var expiration = jwtService.getExpirationTime(jwtToken);
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(jwtRefreshToken)
                    .email(user.getEmail())
                    .expiration(expiration)
                    .role(String.valueOf(user.role.label))
                    .build();
        }
        return null;

    }
}
