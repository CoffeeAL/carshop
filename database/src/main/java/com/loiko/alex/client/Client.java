package com.loiko.alex.client;

import com.loiko.alex.baseentity.BaseEntity;
import com.loiko.alex.order.Order;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@Entity
@Table(name = "client", schema = "carshop_storage")
public class Client implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    Set<Order> orders = new HashSet<>();

    @OneToOne(mappedBy = "client")
    private ClientInfo clientInfo;

    public Client(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
}