package com.loiko.alex.brand;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Brand {

    CITROEN("Citroen"),
    MERCEDES("Mercedes-Benz"),
    PORSCHE("Porsche"),
    DODGE("Dodge"),
    SEAT("Seat"),
    FIAT("Fiat"),
    TOYOTA("Toyota"),
    FORD("Toyota");

    private String name;

    Brand(String name) {
        this.name = name;
    }

    public static Brand getByName(String name) {
        return Arrays.stream(values())
                .filter(n -> n.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}