package com.loiko.alex.user;

import com.loiko.alex.common.BaseDaoImpl;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl  {

//    private static final QUser USER = QUser.user;
//    private final Session SESSION = sessionFactory.getCurrentSession();
//    private static final UserDaoImpl INSTANCE = new UserDaoImpl();
//
//    public static UserDaoImpl getInstance() {
//        return INSTANCE;
//    }
//
//    @Override
//    public Class<User> getEntityClass() {
//        return User.class;
//    }
//
//    @Override
//    public List<User> findAll() {
//        return new JPAQuery<User>(SESSION)
//                .select(USER)
//                .from(USER)
//                .fetch();
//    }
//
//    @Override
//    public Optional<User> findById(Long id) {
//        return new JPAQuery<User>(SESSION)
//                .select(USER)
//                .from(USER)
//                .where(USER.id.eq(id))
//                .fetch()
//                .stream()
//                .findAny();
//    }
}