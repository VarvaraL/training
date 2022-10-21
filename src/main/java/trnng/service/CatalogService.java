package trnng.service;

import org.springframework.stereotype.Service;
import trnng.model.entities.Catalog;
import trnng.model.repository.CatalogRepository;

@Service
public class CatalogService {
    private CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public Catalog getById(String id){
        return catalogRepository.findById(id).get();
    }
}
