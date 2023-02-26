//package com.tutorial.Common.configuration;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@PropertySource({"classpath:persistence-multiple-db.properties"})
//@EnableJpaRepositories(
//        basePackages = "com.tutorial.Common.repository",
//        entityManagerFactoryRef = "primaryEntityManager",
//        transactionManagerRef = "primaryTransactionManager")
//public class PrimaryPersistenceAutoConfiguration {
//    private final DataSource dataSource;
//
//    public PrimaryPersistenceAutoConfiguration(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//
//    @Primary
//    @Bean
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @Primary
//    public LocalContainerEntityManagerFactoryBean primaryEntityManager() {
//        LocalContainerEntityManagerFactoryBean em
//                = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(primaryDataSource());
//        em.setPackagesToScan("com.tutorial.Common.model");
//
//        HibernateJpaVendorAdapter vendorAdapter
//                = new HibernateJpaVendorAdapter();
//        em.setJpaVendorAdapter(vendorAdapter);
//        return em;
//    }
//
//    @Bean
//    @Primary
//    public UserDetailsService userDetailsService() {
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
//        manager.setDataSource(dataSource);
//        return manager;
//    }
//
//    @Primary
//    @Bean
//    public PlatformTransactionManager primaryTransactionManager() {
//
//        JpaTransactionManager transactionManager
//                = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//                primaryEntityManager().getObject());
//        return transactionManager;
//    }
//
//}
