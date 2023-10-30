package com.dompet.sigopback.service;

import com.dompet.sigopback.entity.User;

public interface ValidationCodeService {
    void  create(User user);

    Boolean IsValidCode(String code) ;

}
