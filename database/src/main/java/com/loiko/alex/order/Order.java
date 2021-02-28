package com.loiko.alex.order;

import com.loiko.alex.common.BaseEntity;
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
@Entity
@Table(name = "order", schema = "carshop_storage")
public class Order implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @Column(name = "payment_form")
    @Enumerated(EnumType.STRING)
    private PaymentForm paymentForm;

    @Column(name = "date")
    private LocalDate date;

    @ManyToMany(mappedBy = "orders")
    private Set<SparePart> spareParts = new HashSet<>();
}