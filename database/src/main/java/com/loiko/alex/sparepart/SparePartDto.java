package com.loiko.alex.sparepart;

import com.loiko.alex.producer.Producer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alexey Loiko
 * @project carshop
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SparePartDto {

    private String sparePartName;
    private String vendorCode;
    private Producer producer;
    private Double price;
    private String description;
}