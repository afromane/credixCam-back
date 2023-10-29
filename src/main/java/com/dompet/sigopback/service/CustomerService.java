package com.dompet.sigopback.service;

import com.dompet.sigopback.entity.Customer;

import java.util.List;

public interface CustomerService {
    void  create(Customer customer);
    List<Customer> findAll();
    Customer findById(Long id);

}
