package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(); // this object is used to encode the raw password

		// preparing queries

		String insertUser =
                "INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)";

        String insertAuthority =
                "INSERT INTO authorities (username, authority) VALUES (?, ?)";

		jdbcTemplate.update(insertUser, "John", bcrypt.encode("john@123"), true);
		jdbcTemplate.update(insertUser, "Allen", bcrypt.encode("allen@123"), false);
		jdbcTemplate.update(insertUser, "Alice", bcrypt.encode("alice@123"), true);
		jdbcTemplate.update(insertUser, "David", bcrypt.encode("david@123"), false);
		jdbcTemplate.update(insertUser, "Mark", bcrypt.encode("mark@123"), true);

		jdbcTemplate.update(insertAuthority, "John", "ROLE_ADMIN"); // authority must start with Role_
		jdbcTemplate.update(insertAuthority, "Allen", "ROLE_MANAGER");
		jdbcTemplate.update(insertAuthority, "Alice", "ROLE_MANAGER");
		jdbcTemplate.update(insertAuthority, "David", "ROLE_ADMIN");
		jdbcTemplate.update(insertAuthority, "Mark", "ROLE_LEAD");

	}

}
