package com.loiko.alex.items;

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
@Table(name = "item_in_order", schema = "carshop_storage")
public class ItemInOrder extends BaseEntity<Long> {

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "spare_part_id")
    private Long sparePartId;
}