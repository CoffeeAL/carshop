package com.loiko.alex.producer;

import com.loiko.alex.BaseEntity;
import com.loiko.alex.country.Country;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "producer", schema = "carshop_storage")
public class Producer extends BaseEntity<Long> {

    @Column(name = "producer_name")
    private String producerName;

    @Column(name = "country_name")
    @Enumerated(EnumType.STRING)
    private Country country;
}