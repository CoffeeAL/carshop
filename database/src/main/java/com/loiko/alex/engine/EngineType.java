package com.loiko.alex.engine;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum EngineType {

    PETROL("Бензин"),
    DIESEL("Дизель"),
    ELECTRO("Электро");

    private String name;

    EngineType(String name) {
        this.name = name;
    }

    public static EngineType getByName(String name) {
        return Arrays.stream(values())
                .filter(n -> n.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}