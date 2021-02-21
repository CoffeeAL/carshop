package com.loiko.alex.sparepart;

import com.loiko.alex.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "spare_part", schema = "carshop_storage")
public class SparePart extends BaseEntity<Long> {

    @Column(name = "spare_part_name")
    private String sparePartName;

    @Column(name = "vendor_code")
    private String vendorCode;

    @Column(name = "producer_id")
    private Long producerId;

    @Column(name = "car_id")
    private Long carId;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;
}