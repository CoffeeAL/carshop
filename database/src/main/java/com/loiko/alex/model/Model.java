package com.loiko.alex.model;

import com.loiko.alex.BaseEntity;
import com.loiko.alex.brand.Brand;
import com.loiko.alex.carbody.CarBody;
import com.loiko.alex.engine.EngineType;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car", schema = "carshop_storage")
public class Model extends BaseEntity<Long> {

    @Column(name = "brand")
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column(name = "model")
    private String model;

    @Column(name = "car_body")
    @Enumerated(EnumType.STRING)
    private CarBody carBody;

    @Column(name = "engine_type")
    @Enumerated(EnumType.STRING)
    private EngineType engineType;
}