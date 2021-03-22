package com.loiko.alex.sparepart;

import com.loiko.alex.common.BaseEntity;
import com.loiko.alex.model.Model;
import com.loiko.alex.order.Order;
import com.loiko.alex.producer.Producer;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "spare_part", schema = "carshop_storage")
public class SparePart implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "spare_part_name", nullable = false)
    private String sparePartName;

    @Column(name = "vendor_code")
    private String vendorCode;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @Column(name = "description")
    private String description;

    //TODO transform to BigDecimal
    @Column(name = "price")
    private Double price;

    @ManyToMany(mappedBy = "spareParts")
    private Set<Model> models = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "order_spare_part",
            joinColumns = @JoinColumn(name = "spare_part_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<Order> orders = new HashSet<>();

    public SparePart(String sparePartName, String vendorCode, Producer producer, String description, Double price) {
        this.sparePartName = sparePartName;
        this.vendorCode = vendorCode;
        this.producer = producer;
        this.description = description;
        this.price = price;
    }
}