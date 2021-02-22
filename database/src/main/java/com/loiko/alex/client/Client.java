package com.loiko.alex.client;

import com.loiko.alex.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@Entity
@Table(name = "client", schema = "carshop_storage")
public class Client extends BaseEntity<Long> {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
}