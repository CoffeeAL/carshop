package com.loiko.alex.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("com.loiko.alex")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class SpringConfiguration {

    @Bean
    public DataSource dataSource(@Value("${db.username}") String username,
                                 @Value("${db.password}") String password,
                                 @Value("${db.url}") String url,
                                 @Value("${db.driver}") String driver) {
        DriverManagerDataSource manager = new DriverManagerDataSource();
        manager.setUsername(username);
        manager.setPassword(password);
        manager.setUrl(url);
        manager.setDriverClassName(driver);
        return manager;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource, Properties properties) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.loiko.alex");
        sessionFactory.setHibernateProperties(properties);
        return sessionFactory;
    }

    @Bean
    public Properties hibernateProperties(@Value("classpath:application.properties") Resource resource) throws IOException {
        Properties properties = new Properties();
        properties.load(resource.getInputStream());
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}