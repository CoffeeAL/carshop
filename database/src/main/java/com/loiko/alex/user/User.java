package com.loiko.alex.user;

import com.loiko.alex.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {
        "login",
        "password",
        "email",
        "userInfo"
})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "carshop_storage")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    //TODO fix
    @OneToOne(mappedBy = "user")
    private UserInfo userInfo;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
}