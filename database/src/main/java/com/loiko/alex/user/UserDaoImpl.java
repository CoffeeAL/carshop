package com.loiko.alex.user;

import com.loiko.alex.common.BaseDaoImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao {

    private static final UserDaoImpl INSTANCE = new UserDaoImpl();

    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}