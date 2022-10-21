package trnng.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "activities", schema = "training")
@Data
//@SQLInsert(sql = "insert ")
public class Activity {
    @Id
    @Column(name = "activity_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog_code", columnDefinition = "AGREED")
    private Catalog catalog;

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", catalog=" + catalog +
                '}';
    }
}
