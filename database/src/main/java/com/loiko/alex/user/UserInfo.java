package com.loiko.alex.user;

import com.loiko.alex.common.BaseEntityImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_info", schema = "carshop_storage")
public class UserInfo extends BaseEntityImpl<Long> {

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
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
    private LocalDate birthDate;
}