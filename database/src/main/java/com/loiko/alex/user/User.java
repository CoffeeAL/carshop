package com.loiko.alex.user;

import com.loiko.alex.common.BaseEntityImpl;
import com.loiko.alex.order.Order;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {
        "login",
        "password",
        "email",
        "userInfo",
        "orders"
})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "carshop_storage")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User extends BaseEntityImpl<Long> {

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToOne(mappedBy = "user")
    private UserInfo userInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
}