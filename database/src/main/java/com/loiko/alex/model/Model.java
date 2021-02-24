package com.loiko.alex.model;

import com.loiko.alex.baseentity.BaseEntity;
import com.loiko.alex.brand.Brand;
import com.loiko.alex.carbody.CarBody;
import com.loiko.alex.engine.EngineType;
import com.loiko.alex.sparepart.SparePart;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car", schema = "carshop_storage")
public class Model implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column(name = "model")
    private String model;

    @Column(name = "car_body_type")
    @Enumerated(EnumType.STRING)
    private CarBody carBody;

    @Column(name = "engine_type")
    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    @ManyToMany
    @JoinTable(name = "spare_part_car", schema = "carshop_storage",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "spare_part_id"))
    private Set<SparePart> spareParts = new HashSet<>();
}