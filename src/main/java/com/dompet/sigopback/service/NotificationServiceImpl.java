package com.dompet.sigopback.service;

import com.dompet.sigopback.entity.ValidationCode;
import com.dompet.sigopback.repository.ValidationCodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService{

    private JavaMailSender javaMailSender;

    public void sendMail(ValidationCode validation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(validation.getUser().getEmail());
        message.setSubject("Market Verification Code");

        String texte = String.format(
                "Hello %s, <br /> Your verification code is <b> %s; </b>Have a nice day",
                validation.getUser().getUsername(),
                validation.getCode()
        );
        message.setText(texte);

        javaMailSender.send(message);

    }


}
