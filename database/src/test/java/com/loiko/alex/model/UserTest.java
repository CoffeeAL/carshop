package com.loiko.alex.model;

import com.loiko.alex.TestConfig;
import com.loiko.alex.repository.UserRepository;
import com.loiko.alex.user.User;
import com.loiko.alex.util.Helper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;


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
        assertNotNull(userWithId.isPresent());
    }
}