package com.loiko.alex.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Alexey Loiko
 * @project carshop
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String[] PAGES_FOR_ADMIN = null;
    private static final String[] PAGES_FOR_EVERYONE = null;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(PAGES_FOR_ADMIN)
                .hasAnyAuthority("ADMIN")
                .antMatchers(PAGES_FOR_EVERYONE)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/user", true)
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .userDetailsService(userDetailsService);
    }
}