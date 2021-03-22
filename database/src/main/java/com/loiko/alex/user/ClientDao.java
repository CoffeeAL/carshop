package com.loiko.alex.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientDao {
// TODO скорее всего класс можно будет удалить

    private static final ClientDao INSTANCE = new ClientDao();

    public static ClientDao getInstance() {
        return INSTANCE;
    }
}