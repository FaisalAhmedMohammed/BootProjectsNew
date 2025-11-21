package com.ahmed;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Configuration
public class AppConfig {

	@Autowired
	DataSource dataSource;
	
	@Bean
	public SimpleJdbcCall simpleJdbcCall() {

		SimpleJdbcCall sjc = new SimpleJdbcCall(dataSource);

		return sjc;
	}

}
