package com.dompet.sigopback.service;

import com.dompet.sigopback.entity.Command;
import com.dompet.sigopback.entity.Customer;
import com.dompet.sigopback.exception.EntityNotFoundException;
import com.dompet.sigopback.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl  implements  CustomerService{
    @Autowired
    private final CustomerRepository customerRepository;


    public void create(Customer customer) {
        this.customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        Optional<List<Customer>> optionalCustomerList = Optional.of(this.customerRepository.findAll());
        return optionalCustomerList.orElseThrow(
                ()-> new EntityNotFoundException("Not Found")
        );
    }

    public Customer findById(Long id) {
        Optional<Customer> optionalCustomer = this.customerRepository.findById(id);
        return optionalCustomer.orElseThrow(
                ()-> new EntityNotFoundException("Not Found")
        );
    }
}
