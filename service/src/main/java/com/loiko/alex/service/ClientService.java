package com.loiko.alex.service;

import com.loiko.alex.dao.ClientDao;
import com.loiko.alex.model.Client;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ClientService {

    public static final ClientService INSTANCE = new ClientService();
//    public static Client test;
//    static {
//        test = new Client();
//        test.setClientname("vanya");
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