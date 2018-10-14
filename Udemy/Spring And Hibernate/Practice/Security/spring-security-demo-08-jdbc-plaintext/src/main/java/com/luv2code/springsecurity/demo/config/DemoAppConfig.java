package com.luv2code.springsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    // set up variable to hold the properties
    @Autowired
    private Environment env;

    // set up the logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // define a bean for ViewResolver
    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    // define a bean for security datasource
    @Bean
    public DataSource securityDataSource() {

        // create a connection pool
        ComboPooledDataSource securityDatasource = new ComboPooledDataSource();

        // set the jdbc driver class
        try {
            securityDatasource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }

        // log the connection props
        myLogger.info(">>> jdbc.url = " + env.getProperty("jdbc.url"));
        myLogger.info(">>> jdbc.user = " + env.getProperty("jdbc.user"));

        // set the database connection props
        securityDatasource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDatasource.setUser(env.getProperty("jdbc.user"));
        securityDatasource.setPassword(env.getProperty("jdbc.password"));

        // set connection pool props
        securityDatasource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDatasource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDatasource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDatasource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));


        return securityDatasource;
    }

    // helper method
    // read property and convert it to int
    private int getIntProperty(String propName) {
        int intProp;
        intProp = Integer.parseInt(env.getProperty(propName));
        return intProp;
    }

}
