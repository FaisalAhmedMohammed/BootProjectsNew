package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Order(value = 1)
@Component
public class MyAppRunner implements ApplicationRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        jdbcTemplate.execute(
           "CREATE TABLE ORDERS (\r\n"
           + "    ORDERID INT PRIMARY KEY,\r\n"
           + "    NAME VARCHAR(20),\r\n"
           + "    PRICE DOUBLE,\r\n"
           + "    STATUS VARCHAR(20)\r\n"
           + ");\r\n"
           + ""
        );

        jdbcTemplate.update("INSERT INTO ORDERS VALUES(101 , 'MOBILE',50000.0, 'DELIVERED')");
        jdbcTemplate.update("INSERT INTO ORDERS VALUES(102 , 'LAPTOP',150000.0, 'OUT FOR DELIVERY')");
        jdbcTemplate.update("INSERT INTO ORDERS VALUES(103 , 'POWER BANK',1200.0, 'PENDING')");
        jdbcTemplate.update("INSERT INTO ORDERS VALUES(104 , 'KEYBOARD',700.0, 'ORDER CONFIRMED')");
        jdbcTemplate.update("INSERT INTO ORDERS VALUES(105 , 'MOUSE',550.0, 'DELIVERED')");

        System.out.println("My Runner component :: records inserted in database");
    }
}
