package com.loiko.alex.sparepart;

import com.loiko.alex.country.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SparePartFilterDto {

    private String sparePartName;
    private Country country;
    private Double price;
}