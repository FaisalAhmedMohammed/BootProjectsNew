package com.ahmed.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(title = "Book Rest EndPoints",
						version = "1.0",
						description = "API To Manage the Books",
						license = @License(name = "Ahmed",url = "www.ahmed.in"),
						contact = @Contact(name = "ahmed",email = "faisalahmed53005@gmail.con")
				),
		servers = @Server(url = "http://localhost:9095")
		)
public class ApiConfig {

}
