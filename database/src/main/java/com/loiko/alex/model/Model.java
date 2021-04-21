package com.loiko.alex.model;

import com.loiko.alex.carbody.CarBody;
import com.loiko.alex.common.BaseEntityImpl;
import com.loiko.alex.engine.EngineType;
import com.loiko.alex.sparepart.SparePart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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