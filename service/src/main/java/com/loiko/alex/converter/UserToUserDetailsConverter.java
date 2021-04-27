package com.loiko.alex.converter;

import com.loiko.alex.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author Alexey Loiko
 * @project carshop
 */

@Component
public class UserToUserDetailsConverter implements Converter<User, UserDetails> {

    @Override
    public UserDetails convert(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getLogin())
                .password("{noop}" + user.getPassword())
                .authorities(user.getRole().toString())
                .build();
    }
}