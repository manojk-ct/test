package com.zcon.mobileris.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.zcon.mobileris.config"})
@PropertySource("classpath:mobileris-${env.name}.properties")//(value = {"classpath:HibernateUtils.properties"})
/* Description : This class is for defining database connection properties with multitenancy environment */
public class HibernateUtils {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
     //   factory.setDataSource(dataSource());
        factory.setPackagesToScan(new String[]{"com.zcon.mobileris.entity"});
        factory.setHibernateProperties(hibernateProperties());
        return factory;
    }

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getRequiredProperty("hibernate.driverClassName"));
//        dataSource.setUrl(env.getRequiredProperty("hibernate.databaseurl")+ env.getRequiredProperty("hibernate.masterdb"));
//        dataSource.setUsername(env.getRequiredProperty("hibernate.username"));
//        dataSource.setPassword(env.getRequiredProperty("hibernate.password"));
//
//        return dataSource;
//    }
    

    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.multiTenancy", "DATABASE");
        properties.put("hibernate.tenant_identifier_resolver", "com.zcon.mobileris.config.CurrentTenantIdentifierResolverImpl");
        properties.put("hibernate.multi_tenant_connection_provider", "com.zcon.mobileris.config.MultiTenantConnectionProvider");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
     //   properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setAutodetectDataSource(false);
        txManager.setSessionFactory(s);
        return txManager;
    }
}
