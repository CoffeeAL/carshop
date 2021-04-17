package com.loiko.alex.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientService {

    public static final ClientService INSTANCE = new ClientService();

    public static ClientService getInstance() {
        return INSTANCE;
    }
}