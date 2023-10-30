package com.dompet.sigopback.service;

import com.dompet.sigopback.entity.User;
import com.dompet.sigopback.entity.ValidationCode;
import com.dompet.sigopback.repository.ValidationCodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.Random;

import static java.time.temporal.ChronoUnit.MINUTES;

@AllArgsConstructor
@Service
public class ValidationCodeServiceImpl implements  ValidationCodeService {
    private  final Integer expirationDuration = 5; // 5 minutes

    private ValidationCodeRepository validationCodeRepository;
    private NotificationService notificationService;
    public void create(User user) {
        ValidationCode validation = new ValidationCode();
        validation.setUser(user);
        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(this.expirationDuration, MINUTES);
        validation.setExpiration(expiration);
        Random random = new Random();
        int randomInteger = random.nextInt(9999);
        String code = String.format("%04d", randomInteger);

        validation.setCode(code);
        this.validationCodeRepository.save(validation);
        this.notificationService.sendMail(validation);
    }

    public Boolean IsValidCode(String code) {
       // Optional<ValidationCode> optionalValidationCode = this.validationCodeRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Votre code est invalide"));
        return this.validationCodeRepository.findByCode(code).isPresent() == true ? true : false ;
    }
}
