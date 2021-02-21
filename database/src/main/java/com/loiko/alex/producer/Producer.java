package com.loiko.alex.producer;

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
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "producer_name")
    private String producerName;

    @Column(name = "country_id")
    private Country country;
}