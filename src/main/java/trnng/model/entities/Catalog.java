package trnng.model.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "catalog", schema = "training")
@Data
public class Catalog {
    @Id
    @Column(name = "catalog_code", nullable = false)
    private String id;

    @Column(name = "catalog_status", nullable = false)
    private String status;


    @Override
    public String toString() {
        return "Catalog{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
