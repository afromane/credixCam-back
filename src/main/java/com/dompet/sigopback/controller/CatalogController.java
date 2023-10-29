package com.dompet.sigopback.controller;

import com.dompet.sigopback.dto.CatalogDTO;
import com.dompet.sigopback.entity.Catalog;
import com.dompet.sigopback.exception.message.SuccessMessage;
import com.dompet.sigopback.service.CatalogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/catalog/")
public class CatalogController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CatalogService catalogService;

    @PostMapping()
    public ResponseEntity<Object> create (@RequestBody Catalog catalog){
        this.catalogService.create(catalog);
        SuccessMessage successMessage = SuccessMessage.builder()
                .code(200).message("record successfully")
                .build();
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CatalogDTO>> findAll(){
        return new ResponseEntity<>( this.catalogService.findAll()
                .stream()
                .map(typeTontine -> modelMapper.map(typeTontine,CatalogDTO.class))
                .collect(Collectors.toList()),HttpStatus.OK );

    }
    @GetMapping("{id}")
    public ResponseEntity<CatalogDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(
                modelMapper.map(this.catalogService.findById(id),CatalogDTO.class),
                HttpStatus.OK);
    }

}
