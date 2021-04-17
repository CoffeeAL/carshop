package com.loiko.alex.model;

import com.loiko.alex.TestConfig;
import com.loiko.alex.configuration.DatabaseConfiguration;
import com.loiko.alex.repository.UserRepository;
import com.loiko.alex.user.Admin;
import com.loiko.alex.user.User;
import com.loiko.alex.user.UserDaoImpl;
import com.loiko.alex.util.ApplicationSessionFactory;
import com.loiko.alex.util.Helper;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class UserTest {

    @Autowired
    private Helper helper;

    @Autowired
    private EntityManager manager;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        helper.cleanDataBase();
        helper.insertingData();
    }

    @Test
    public void checkContext() {
        assertNotNull(userRepository);
    }

    @Test
    public void checkFindAllUsers() {
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void checkFindById() {
        Optional<User> userWithId = userRepository.findById(1L);
        assertTrue(userWithId.isPresent());
    }
}