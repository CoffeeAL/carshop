package com.loiko.alex.user;

import com.loiko.alex.common.BaseEntityImpl;
import com.loiko.alex.order.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@ToString(exclude = "orders")
@Table(name = "user", schema = "carshop_storage")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntityImpl<Long> {

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToOne(mappedBy = "user")
    private UserInfo userInfo;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Orders> orders = new HashSet<>();

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
}