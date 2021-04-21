package com.loiko.alex.user;

import com.loiko.alex.user.role.ClientRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
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