package com.loiko.alex.order;

import com.loiko.alex.BaseEntity;
import com.loiko.alex.paymentform.PaymentForm;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "spare_part", schema = "carshop_storage")
public class Order extends BaseEntity<Long> {

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "payment_form")
    @Enumerated(EnumType.STRING)
    private PaymentForm paymentForm;

    //TODO сделать дату
    @Column(name = "date")
    private String date;
}