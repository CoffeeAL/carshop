package com.loiko.alex.producer;

import com.loiko.alex.common.BaseEntityImpl;
import com.loiko.alex.country.Country;
import com.loiko.alex.sparepart.SparePart;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"producerName", "country", "spareParts"})
@Builder
@ToString(exclude = "spareParts")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Table(name = "producer", schema = "carshop_storage")
public class Producer extends BaseEntityImpl<Long> {

    @Column(name = "producer_name", nullable = false)
    private String producerName;

    @Column(name = "country_name")
    @Enumerated(EnumType.STRING)
    private Country country;

    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL)
    private Set<SparePart> spareParts = new HashSet<>();

    @Builder
    public Producer(String producerName, Country country) {
        this.producerName = producerName;
        this.country = country;
    }
}