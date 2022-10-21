package trnng.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trnng.model.entities.Catalog;

import java.util.UUID;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, String> {
}
