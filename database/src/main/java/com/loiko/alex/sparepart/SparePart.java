package com.loiko.alex.sparepart;

import com.loiko.alex.common.BaseEntityImpl;
import com.loiko.alex.model.Model;
import com.loiko.alex.order.Orders;
import com.loiko.alex.producer.Producer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@ToString(exclude = {"models", "orders"})
@Entity
@Table(name = "spare_part", schema = "carshop_storage")
public class SparePart extends BaseEntityImpl<Long> {

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

//    @ManyToMany
//    @JoinTable(name = "spare_part_car", schema = "carshop_storage",
//            joinColumns = @JoinColumn(name = "spare_part_id"),
//            inverseJoinColumns = @JoinColumn(name = "car_id"))
//    private Set<Model> models = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "order_spare_part",
            joinColumns = @JoinColumn(name = "spare_part_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<Orders> orders = new HashSet<>();

    public SparePart(String sparePartName, String vendorCode, Producer producer, String description, Double price) {
        this.sparePartName = sparePartName;
        this.vendorCode = vendorCode;
        this.producer = producer;
        this.description = description;
        this.price = price;
    }
}