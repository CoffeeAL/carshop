package com.loiko.alex.user;

import com.loiko.alex.order.Order;
import com.loiko.alex.user.role.ClientRole;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "client", schema = "carshop_storage")
@PrimaryKeyJoinColumn(name = "client_id")
public class Client extends User {

    @Column(name = "last_order_date")
    private LocalDate lastOrderDate;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private ClientRole role;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    Set<Order> orders = new HashSet<>();

    public Client(String login, String password, String email, LocalDate lastOrderDate, ClientRole role) {
        super(login, password, email);
        this.lastOrderDate = lastOrderDate;
        this.role = role;
    }
}