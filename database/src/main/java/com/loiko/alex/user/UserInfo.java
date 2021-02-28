package com.loiko.alex.user;

import com.loiko.alex.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_info", schema = "carshop_storage")
public class UserInfo implements BaseEntity<Long> {

    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Embedded
    private FullName fullName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "birth_date")
    private LocalDate date;

    public UserInfo(User user, FullName fullName, Integer age, String phoneNumber, String hobby, LocalDate date) {
        this.user = user;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.hobby = hobby;
        this.date = date;
    }
}