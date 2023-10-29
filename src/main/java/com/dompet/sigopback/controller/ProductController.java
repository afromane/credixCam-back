package com.dompet.sigopback.controller;

import com.dompet.sigopback.dto.CustomerDTO;
import com.dompet.sigopback.dto.ProductDTO;
import com.dompet.sigopback.entity.Customer;
import com.dompet.sigopback.entity.Product;
import com.dompet.sigopback.exception.message.SuccessMessage;
import com.dompet.sigopback.service.CustomerService;
import com.dompet.sigopback.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/product/")
public class ProductController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<Object> create (@RequestBody Product product){
        this.productService.create(product);
        SuccessMessage successMessage = SuccessMessage.builder()
                .code(201).message("record successfully")
                .build();
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> findAll(){
        return new ResponseEntity<>( this.productService.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList()),HttpStatus.OK );
    }
    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(
                modelMapper.map(this.productService.findById(id),ProductDTO.class),
                HttpStatus.OK);
    }
}
