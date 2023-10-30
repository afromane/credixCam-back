package com.dompet.sigopback.controller.auth;

import com.dompet.sigopback.dto.AuthentificationDTO;
import com.dompet.sigopback.entity.User;
import com.dompet.sigopback.repository.UserRepository;
import com.dompet.sigopback.security.jwt.JwtService;
import com.dompet.sigopback.service.UserService;
import com.dompet.sigopback.service.ValidationCodeService;
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
    public  final UserService userService;
    public  final ValidationCodeService validationCodeService;

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

    public void generateCode (String email){
        User user = this.userService.findByEmail(email);
        this.validationCodeService.create(user);
    }
    public Boolean verifyCode (String code){
        return this.validationCodeService.IsValidCode(code);
    }
}
