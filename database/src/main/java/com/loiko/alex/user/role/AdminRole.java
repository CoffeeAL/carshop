package com.loiko.alex.user.role;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum AdminRole {

    MAIN_ADMIN("Главный администратор, который может назначать других администраторов"),
    ADMIN("Обычный администратор, не имеющий права назначать других администраторов");

    private String role;

    AdminRole(String role) {
        this.role = role;
    }

    public static AdminRole getByName(String name) {
        return Arrays.stream(values())
                .filter(n -> n.getRole().equals(name))
                .findFirst()
                .orElse(null);
    }
}
