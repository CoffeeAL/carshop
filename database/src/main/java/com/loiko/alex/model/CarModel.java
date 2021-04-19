package com.loiko.alex.model;

import com.loiko.alex.brand.Brand;
import com.loiko.alex.common.BaseEntity;
import com.loiko.alex.common.BaseEntityImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Embeddable
public class CarModel {

    @Column(name = "brand", nullable = false)
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column(name = "model", nullable = false)
    private String model;
}