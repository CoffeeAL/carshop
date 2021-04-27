package com.loiko.alex.user;

import com.loiko.alex.user.role.AdminRole;
import com.loiko.alex.user.role.UserRole;
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

@Data
@Entity
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "salary")
@Table(name = "admin", schema = "carshop_storage")
@PrimaryKeyJoinColumn(name = "admin_id")
public class Admin extends User {

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private AdminRole adminRole;

    @Builder
    public Admin(String login, String password, String email, Integer salary, AdminRole adminRole) {
        super(login, password, email, UserRole.ADMIN);
        this.salary = salary;
        this.adminRole = adminRole;
    }
}