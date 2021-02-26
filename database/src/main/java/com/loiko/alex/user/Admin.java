package com.loiko.alex.user;

import com.loiko.alex.user.role.AdminRole;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "admin", schema = "carshop_storage")
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User {

    @Column(name = "salary")
    private Double salary;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private AdminRole adminRole;

    public Admin(String login, String password, String email, Double salary, AdminRole adminRole) {
        super(login, password, email);
        this.salary = salary;
        this.adminRole = adminRole;
    }
}