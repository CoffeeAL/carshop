package com.loiko.alex.model;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client", schema = "carshop_storage")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String clientname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    public Client(String login, String password, String clientname, Integer age, String phoneNumber, String email) {
        this.login = login;
        this.password = password;
        this.clientname = clientname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}