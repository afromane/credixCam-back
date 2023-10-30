package com.dompet.sigopback.service;

import com.dompet.sigopback.entity.ValidationCode;

public interface NotificationService {
     void sendMail(ValidationCode validation);

}
