package com.loiko.alex.user;

import com.loiko.alex.user.role.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Alexey Loiko
 * @project carshop
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class AdminDto {

    private Double salary;
    private AdminRole adminRole;
}