package com.zcon.mobileris.config;

import com.mchange.v2.c3p0.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
/* Description: This class is for selecting datasource based on multitenant login */
public class MultiTenantConnectionProvider extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    private static final long serialVersionUID = 6241633589847209550L;

    private ComboPooledDataSource defaultDataSource;

    Properties props; 
    
    /* This constructor is for setting main basic datasource which is default database to hit for the request*/
    public MultiTenantConnectionProvider() {

        Resource resource = new ClassPathResource("/mobileris-"+System.getProperty("env.name")+".properties");
        props = null;
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException ex) {
            Logger.getLogger(MultiTenantConnectionProvider.class.getName()).log(null, ex);
        }
        defaultDataSource = new ComboPooledDataSource();
        defaultDataSource.setJdbcUrl((String) props.get("hibernate.databaseurl")+(String) props.get("hibernate.masterdb"));//"jdbc:mysql://10.235.4.54:3306/dev-mobile-ris");
        defaultDataSource.setUser((String) props.get("hibernate.username"));//"root");
        defaultDataSource.setPassword((String) props.get("hibernate.password"));//"root");
        try {
            defaultDataSource.setDriverClass((String) props.get("hibernate.driverClassName"));//"com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
        }
        defaultDataSource.setInitialPoolSize(2);
        defaultDataSource.setMinPoolSize(5);
        defaultDataSource.setMaxPoolSize(20);
        defaultDataSource.setMaxIdleTime(180);
        defaultDataSource.setIdleConnectionTestPeriod(150);
        defaultDataSource.setMaxStatements(15);
    }

    @Override
    protected DataSource selectAnyDataSource() {
        return defaultDataSource;
    }
    
    /* This function is for switching datasource as per login crendentials */
    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
       
        PooledDataSource pds = C3P0Registry.pooledDataSourceByName(tenantIdentifier);
        if (pds == null) {
            ComboPooledDataSource cpds = new ComboPooledDataSource(tenantIdentifier);
            cpds.setJdbcUrl(((String) props.get("hibernate.databaseurl")) + tenantIdentifier);
            System.out.println("connected to tenant1");
            System.out.println("-----------" + tenantIdentifier);
            cpds.setUser((String) props.get("hibernate.username"));//"root");
            cpds.setPassword((String) props.get("hibernate.password"));//"root");
            cpds.setInitialPoolSize(2);
            cpds.setMinPoolSize(5);
            cpds.setMaxPoolSize(20);
            cpds.setMaxIdleTime(180);
            cpds.setIdleConnectionTestPeriod(150);
            cpds.setMaxStatements(15);
            try {
                cpds.setDriverClass((String) props.get("hibernate.driverClassName"));//"com.mysql.jdbc.Driver");
            } catch (PropertyVetoException e) {
            }
            return cpds;

        }
        return pds;

    }

}
