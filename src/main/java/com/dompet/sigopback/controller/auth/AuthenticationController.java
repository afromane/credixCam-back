package com.dompet.sigopback.controller.auth;

import com.dompet.sigopback.dto.AuthentificationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("authenticate")
    public ResponseEntity<Object> connexion(@RequestBody AuthentificationDTO authentificationDTO) {

        return new ResponseEntity<>(this.authenticationService.authenticate(authentificationDTO), HttpStatus.OK);
    }

    @GetMapping("generate/{email}")
    public void generateCode(@PathVariable String email) {
        this.authenticationService.generateCode(email);
    }

    @GetMapping("verify/{code}")
    public ResponseEntity<Boolean> verifyCode(@PathVariable String code) {
        return new ResponseEntity<>(this.authenticationService.verifyCode(code), HttpStatus.OK);

    }

}
