package com.example.learnspringboot.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
//    @Bean
//    public DataSource getDataSource(){
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://localhost:3306/learningspringboot?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&createDatabaseIfNotExist=true");
//        dataSourceBuilder.username("root");
//        dataSourceBuilder.password("passer");
//        return dataSourceBuilder.build();
//    }
}
