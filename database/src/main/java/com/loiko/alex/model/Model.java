package com.loiko.alex.model;

import com.loiko.alex.carbody.CarBody;
import com.loiko.alex.common.BaseEntityImpl;
import com.loiko.alex.engine.EngineType;
import com.loiko.alex.sparepart.SparePart;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "car", schema = "carshop_storage")
public class Model extends BaseEntityImpl<Long> {

    @Embedded
    private CarModel carModel;

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

    public Model(CarModel carModel, CarBody carBody, EngineType engineType) {
        this.carModel = carModel;
        this.carBody = carBody;
        this.engineType = engineType;
    }
}