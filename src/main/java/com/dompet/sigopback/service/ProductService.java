package com.dompet.sigopback.service;

import com.dompet.sigopback.entity.Product;

import java.util.List;

public interface ProductService {
    void  create(Product product);
    List<Product> findAll();
    Product findById(Long id);
}
