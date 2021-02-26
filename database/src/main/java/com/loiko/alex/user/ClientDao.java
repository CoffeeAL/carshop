package com.loiko.alex.user;

import com.loiko.alex.user.role.ClientRole;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientDao {

    private static final ClientDao INSTANCE = new ClientDao();

    public Client getDefaultClient() {
        if (true) {
            return null;
        } else {
            return Client.builder()
                    .lastOrderDate(LocalDate.now())
                    .role(ClientRole.ORDINARY_CLIENT)
                    .build();
        }
    }

    public static ClientDao getInstance() {
        return INSTANCE;
    }
}