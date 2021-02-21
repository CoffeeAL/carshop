package com.loiko.alex.service;

import com.loiko.alex.client.ClientDao;
import com.loiko.alex.client.Client;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClientService {

    public static final ClientService INSTANCE = new ClientService();
//    public static Client test;
//    static {
//        test = new Client();
//        test.setClientName("vanya");
//        test.setAge(45);
//    }

    public Client getDefaultClient() {
        return ClientDao.getInstance().getDefaultClient();
//        return test;
    }

    public static ClientService getInstance() {
        return INSTANCE;
    }
}