package com.dompet.sigopback.service;

import com.dompet.sigopback.entity.Catalog;
import com.dompet.sigopback.exception.EntityAlreadyExistsException;
import com.dompet.sigopback.exception.EntityNotFoundException;
import com.dompet.sigopback.repository.CatalogRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private final CatalogRepository catalogRepository;
    public void create(Catalog catalog) {
        Optional<Catalog> optionalCatalog = this.catalogRepository.findByLabel(catalog.label);
        if (!optionalCatalog.isPresent())
         this.catalogRepository.save(catalog);
        else
             new EntityAlreadyExistsException("Conflict");

    }

    public List<Catalog> findAll() {

        Optional<List<Catalog>> optionalCatalogList = Optional.of(this.catalogRepository.findAll());
        return optionalCatalogList.orElseThrow(
                ()-> new EntityNotFoundException("Not Found")
        );
    }

    public Catalog findById(Long id) {
        Optional<Catalog> optionalTypeTontine = this.catalogRepository.findById(id);
        return optionalTypeTontine.orElseThrow(
                ()-> new EntityNotFoundException("Not found")
        ) ;
    }



    public Optional<Catalog> findByLabel(String label) {
        Optional<Catalog> optionalCatalog = this.catalogRepository.findByLabel(label);
        return optionalCatalog ;
    }

    public void update(Long id, Catalog catalog) {
        Catalog tmp = this.findById(id);
        tmp.label = catalog.label;

        this.catalogRepository.save(tmp);
    }

    public void remove(Catalog catalog) {
        this.catalogRepository.delete(catalog);
    }
}
