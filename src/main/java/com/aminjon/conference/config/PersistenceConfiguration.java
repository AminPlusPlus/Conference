package com.aminjon.conference.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

//    @Bean
//    public DataSource dataSource (){
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.url("");
//        builder.username("");
//        builder.password("");
//        System.out.println("Data source bean");
//        return builder.build();
//    }
}
