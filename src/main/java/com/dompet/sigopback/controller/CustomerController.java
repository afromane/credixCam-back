package com.dompet.sigopback.controller;

import com.dompet.sigopback.dto.CatalogDTO;
import com.dompet.sigopback.dto.CustomerDTO;
import com.dompet.sigopback.entity.Catalog;
import com.dompet.sigopback.entity.Customer;
import com.dompet.sigopback.exception.message.SuccessMessage;
import com.dompet.sigopback.service.CatalogService;
import com.dompet.sigopback.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customer/")
public class CustomerController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity<Object> create (@RequestBody Customer customer){
        this.customerService.create(customer);
        SuccessMessage successMessage = SuccessMessage.builder()
                .code(201).message("record successfully")
                .build();
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CustomerDTO>> findAll(){
        return new ResponseEntity<>( this.customerService.findAll()
                .stream()
                .map(customer -> modelMapper.map(customer,CustomerDTO.class))
                .collect(Collectors.toList()),HttpStatus.OK );
    }
    @GetMapping("{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(
                modelMapper.map(this.customerService.findById(id),CustomerDTO.class),
                HttpStatus.OK);
    }
}
