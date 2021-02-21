package com.loiko.alex.client;

import com.loiko.alex.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client_info", schema = "carshop_storage")
public class ClientInfo extends BaseEntity<Long> {

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "date")
    //TODO сделать дату
    private String date;
}