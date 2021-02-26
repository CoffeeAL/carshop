package com.loiko.alex.service;

import com.loiko.alex.user.ClientDao;
import com.loiko.alex.user.User;
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

    public User getDefaultClient() {
        return ClientDao.getInstance().getDefaultClient();
//        return test;
    }

    public static ClientService getInstance() {
        return INSTANCE;
    }
}