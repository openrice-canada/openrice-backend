package ca.openricecan.data.entity.district;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "district")
public class DistrictEntity {
    @Id
    @SequenceGenerator(name = "district_sequence", sequenceName = "district_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "district_sequence")
    @Column(name = "district_id", updatable = false, nullable = false)
    private UUID districtId;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at", updatable = false)
    private final ZonedDateTime createdAt = ZonedDateTime.now();
}
