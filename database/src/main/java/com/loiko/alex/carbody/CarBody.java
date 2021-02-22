package com.loiko.alex.carbody;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CarBody {

    COUPE("Купе", "Две двери, один или два ряда сидений и структурно отдельный багажник"),
    SEDAN("Седан", "Обычно четыре двери, два или три ряда сидений и структурно отдельный багажник"),
    HATCHBACK("Хэтчбэк", "Один или два ряда сидений, дверь в задней стенке и укороченный задний свес"),
    CROSSOVER("Внедорожник", "Высокая посадка водителей и пассажиров"),
    MINIVAN("Минивэн", "Однообъёмный кузов и обычно три ряда сидений"),
    UNIVERSAL("Универсал", "Седан с увеличенным багажным отделением и дополнительной подъёмной дверью в задке"),
    LIMO("Лимузин","Перегородка между отделением водителя и остальным салоном");

    private String name;
    private String description;

    CarBody(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static CarBody getByName(String name) {
        return Arrays.stream(values())
                .filter(n -> n.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}