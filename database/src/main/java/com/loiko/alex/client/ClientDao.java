package com.loiko.alex.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientDao {

    private static final ClientDao INSTANCE = new ClientDao();

    public Client getDefaultClient() {
        if (true) {
            return null;
        } else {
            return Client.builder()
                    .login("Ivan")
                    .password("PasswordIvan")
                    .clientName("Ivan")
                    .age(25)
                    .phoneNumber("123-45-67")
                    .email("ivan@gmail.com")
                    .build();
        }
    }

    public static ClientDao getInstance() {
        return INSTANCE;
    }
}