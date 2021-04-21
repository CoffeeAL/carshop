package com.loiko.alex.model;

import com.loiko.alex.brand.Brand;
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
@AllArgsConstructor(staticName = "of")
@Embeddable
public class CarModel {

    @Column(name = "brand", nullable = false)
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Column(name = "model", nullable = false)
    private String model;
}