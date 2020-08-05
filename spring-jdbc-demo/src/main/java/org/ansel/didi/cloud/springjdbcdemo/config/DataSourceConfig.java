package org.ansel.didi.cloud.springjdbcdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_action_db");
        dataSource.setUsername("root");
        dataSource.setPassword("940208kkk");
        return dataSource;
    }

    public static void main(String[] args) {
        System.out.println(Driver.class.getName());
    }
}
