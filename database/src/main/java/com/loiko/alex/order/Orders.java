package com.loiko.alex.order;

import com.loiko.alex.common.BaseEntityImpl;
import com.loiko.alex.user.User;
import com.loiko.alex.paymentform.PaymentForm;
import com.loiko.alex.sparepart.SparePart;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "spareParts")
@Entity
@Table(name = "order", schema = "carshop_storage")
public class Orders extends BaseEntityImpl<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User client;

    @Column(name = "payment_form")
    @Enumerated(EnumType.STRING)
    private PaymentForm paymentForm;

    @Column(name = "date")
    private LocalDate date;

//    @ManyToMany(mappedBy = "orders")
//    private Set<SparePart> spareParts = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "order_spare_part", schema = "carshop_storage",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "spare_part_id"))
    private Set<SparePart> spareParts = new HashSet<>();
}