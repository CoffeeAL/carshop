package com.loiko.alex.user.role;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author Alexey Loiko
 * @project carshop
 */

@Getter
public enum UserRole {

    ADMIN("Главный или обычный администратор"),
    SIMPLE_USER("Клиент");

    private String userRole;

    UserRole(String role) {
        this.userRole = role;
    }

    public static UserRole getByName(String name) {
        return Arrays.stream(values())
                .filter(n -> n.getUserRole().equals(name))
                .findFirst()
                .orElse(null);
    }
}