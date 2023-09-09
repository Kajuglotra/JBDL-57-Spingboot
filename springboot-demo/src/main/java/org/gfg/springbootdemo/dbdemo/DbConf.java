package org.gfg.springbootdemo.dbdemo;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Configuration
public class DbConf {

    @Bean
    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl_57", "root", "rootroot");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Bean
    public DataSource getDatasource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/jbdl_57");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("rootroot");
        return dataSourceBuilder.build();
    }
}
