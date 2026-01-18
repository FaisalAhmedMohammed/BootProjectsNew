package com.ahmed.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		
		info = @Info(title = "Employee CRUD Operations",
				version = "1.0",
				description = "Employee RESTEnd Points To Perform CURD operations",
				
				license = @License(name = "Ahmed" , url = "http://ahmed.in"),
				contact = @Contact(name = "support" ,email = "mohammedfaisalahmed873@gmail.com")
				),
		servers = @Server(url = "http://localhost:9095" , description = "Local Server")
		
		)
public class ApiConfig {

}
