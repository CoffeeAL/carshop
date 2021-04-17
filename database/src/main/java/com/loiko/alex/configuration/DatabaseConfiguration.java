package com.loiko.alex.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@PropertySource({"classpath:database.properties", "classpath:hibernate.properties"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.loiko.alex.repository")
public class DatabaseConfiguration {

    @Bean
    public DataSource dataSource(@Value("${db.user}") String username,
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
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Properties hibernateProperties) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean managerFactory = new LocalContainerEntityManagerFactoryBean();
        managerFactory.setJpaVendorAdapter(vendorAdapter);
        managerFactory.setPackagesToScan("com.loiko.alex");
        managerFactory.setDataSource(dataSource);
        managerFactory.setJpaProperties(hibernateProperties);
        return managerFactory;
    }

    @Bean
    public Properties hibernateProperties(@Value("classpath:hibernate.properties") Resource resource) throws IOException {
        Properties properties = new Properties();
        properties.load(resource.getInputStream());
        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory managerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(managerFactory);
        return jpaTransactionManager;
    }
}