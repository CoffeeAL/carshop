package com.loiko.alex.service;

import com.loiko.alex.dao.ClientDao;
import com.loiko.alex.model.Client;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClientService {

    public static final ClientService INSTANCE = new ClientService();

    public Client getDefaultClient() {
        return ClientDao.getInstance().getDefaultClient();
    }

    public static ClientService getInstance() {
        return INSTANCE;
    }
}