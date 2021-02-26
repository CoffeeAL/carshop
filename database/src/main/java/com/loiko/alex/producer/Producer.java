package com.loiko.alex.producer;

import com.loiko.alex.baseentity.BaseEntity;
import com.loiko.alex.country.Country;
import com.loiko.alex.sparepart.SparePart;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"producerName", "country", "spareParts"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "producer", schema = "carshop_storage")
public class Producer implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "producer_name", nullable = false)
    private String producerName;

    @Column(name = "country_name")
    @Enumerated(EnumType.STRING)
    private Country country;

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL)
    private Set<SparePart> spareParts = new HashSet<>();
}