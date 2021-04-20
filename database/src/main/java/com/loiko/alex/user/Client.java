package com.loiko.alex.user;

import com.loiko.alex.user.role.ClientRole;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "client", schema = "carshop_storage")
@PrimaryKeyJoinColumn(name = "client_id")
public class Client extends User {

    @Column(name = "last_order_date")
    private LocalDate lastOrderDate;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private ClientRole role;

    @Builder
    public Client(String login, String password, String email, ClientRole role) {
        super(login, password, email);
        this.role = role;
    }
}