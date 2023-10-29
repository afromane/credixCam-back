package com.dompet.sigopback.service;


import com.dompet.sigopback.entity.Catalog;

import java.util.List;
import java.util.Optional;

public interface CatalogService {

     void  create(Catalog catalog);
     List<Catalog> findAll();
     Catalog findById(Long id);
      void update (Long id, Catalog catalog);

     void remove (Catalog catalog);
     Optional<Catalog> findByLabel(String label);

}
