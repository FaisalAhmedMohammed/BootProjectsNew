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

		jdbcTemplate
				.execute("CREATE TABLE IF NOT EXISTS EMP (\r\n"
						+ "    EMPNO INT,\r\n"
						+ "    ENAME VARCHAR(20),\r\n"
						+ "    SAL DOUBLE,\r\n"
						+ "    DEPTNO INT,\r\n"
						+ "    PRIMARY KEY(EMPNO)\r\n"
						+ ")\r\n"
						+ "");

		System.out.println("Data Base Table is created");

		jdbcTemplate.update("INSERT INTO EMP VALUES(7744,'SMITH',5000.0,20)");
		jdbcTemplate.update("INSERT INTO EMP VALUES(7654,'SOPHIA',4000.0,10)");
		jdbcTemplate.update("INSERT INTO EMP VALUES(7123,'ALLEN',3000.0,20)");
		jdbcTemplate.update("INSERT INTO EMP VALUES(7764,'MILLER',6000.0,12)");
		jdbcTemplate.update("INSERT INTO  EMP VALUES(7876,'SCOTT',5000.0,17)");

		System.out.println("MyAppRunner :: rows are inserted");

	}

}
