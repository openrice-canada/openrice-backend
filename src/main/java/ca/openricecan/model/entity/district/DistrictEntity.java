package ca.openricecan.model.entity.district;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "district", schema = "public")
public class DistrictEntity {
    @Id
    @GeneratedValue
    @Column(name = "district_id", updatable = false, nullable = false)
    private UUID districtId;

    @Column(name = "name")
    private String name;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "active")
    private Boolean active = true;

}
