package com.loiko.alex.country;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Country {

    JAPAN("Япония"),
    USA("Америка"),
    FRANCE("Франция"),
    GERMANY("Германия"),
    ITALY("Италия"),
    RUSSIA("Россия"),
    SPAIN("Испания"),
    AUSTRALIA("Австралия"),
    UK("Англия"),
    POLAND("Польша");

    private String name;

    Country(String name) {
        this.name = name;
    }

    public static Country getByName(String name) {
        return Arrays.stream(values())
                .filter(n -> n.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}