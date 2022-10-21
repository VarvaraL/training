package trnng.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trnng.model.entities.Catalog;
import trnng.service.CatalogService;

@RestController
@RequestMapping("/api/catalogs")
public class CatalogController {

    CatalogService  catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping(value = "/{id}")
    public Catalog getCatalog(@PathVariable(name = "id") String id){
        System.out.println(catalogService.getById(id).toString());
        return catalogService.getById(id);
    }
}
