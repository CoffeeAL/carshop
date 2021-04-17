package com.loiko.alex.model;

import com.loiko.alex.brand.Brand;
import com.loiko.alex.common.BaseEntity;
import com.loiko.alex.common.BaseEntityImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@NoArgsConstructor
@Embeddable
public class CarModel {

    @Column(name = "brand", nullable = false)
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column(name = "model", nullable = false)
    private String model;

    public CarModel(Brand brand, String model) {
        this.brand = brand;
        this.model = model;
    }
}