package com.loiko.alex.user.role;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ClientRole {

    VIP_CLIENT("Вип-клиент"),
    ORDINARY_CLIENT("Обычный клиент");

    private String role;

    ClientRole(String role) {
        this.role = role;
    }

    public static ClientRole getByName(String name) {
        return Arrays.stream(values())
                .filter(n -> n.getRole().equals(name))
                .findFirst()
                .orElse(null);
    }
}