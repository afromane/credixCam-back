package com.dompet.sigopback.service;

import com.dompet.sigopback.entity.Customer;
import com.dompet.sigopback.entity.Product;
import com.dompet.sigopback.exception.EntityNotFoundException;
import com.dompet.sigopback.repository.CustomerRepository;
import com.dompet.sigopback.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;
    public void create(Product product) {
        this.productRepository.save(product);
    }

    public List<Product> findAll() {
        Optional<List<Product>> optionalProducts = Optional.of(this.productRepository.findAll());
        return optionalProducts.orElseThrow(
                ()-> new EntityNotFoundException("Not Found")
        );
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = this.productRepository.findById(id);
        return optionalProduct.orElseThrow(
                ()-> new EntityNotFoundException("Not Found")
        );
    }
}
