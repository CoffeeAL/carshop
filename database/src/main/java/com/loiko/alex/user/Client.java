package com.loiko.alex.user;

import com.loiko.alex.user.role.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
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

    @Builder
    public Client(String login, String password, String email) {
        super(login, password, email, UserRole.SIMPLE_USER);
    }
}