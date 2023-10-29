package com.dompet.sigopback.service;
import com.dompet.sigopback.entity.User;

import java.util.List;

public interface UserService   {

     void create(User user);

     List<User> findAll();
     User findByEmail(String email);
}
