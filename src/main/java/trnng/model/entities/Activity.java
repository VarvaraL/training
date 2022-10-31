package trnng.model.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "activities", schema = "training")
@Data
public class Activity {
    @Id
    @Column(name = "activity_id", nullable = false)
    private Integer id;

    @Column(name = "catalog_code", columnDefinition = "AGREED")
    private UUID catalogId;

    //for revert
}
