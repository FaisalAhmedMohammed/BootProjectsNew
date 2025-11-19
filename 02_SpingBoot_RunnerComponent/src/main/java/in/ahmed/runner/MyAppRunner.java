package in.ahmed.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/*•	If you want to execute a task (logic) for one time in a spring boot application, immediately when it starts, then you have to define a Spring Boot runner component.
•	For example, if you want to load all the Job Schedules from the Database, immediately when the application starts, then you can define a Spring Boot Runner component for this.
•	For example, if you want to insert the application admin’s details to the database, immediately when the application starts, then you can define a Spring Boot Runner component for this.
•	To define a Spring Boot Runner component, the Spring Boot has provided two runner interfaces.
1.	CommandLineRunner interface (legacy)
2.	Application Runner interface

•	They both are functional interface they have one abstract method we have to override.
Note: CommandLineRunner is a legacy interface, and to define runner components, we got a new one called Application Runner.

•	The runner components are executed immediately when application starts, if they are registered into the Spring Container.
•	So, we should add @Component annotation, to register a runner component into the spring container.
*/
@Component
@Order(value = 2)
public class MyAppRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("This is Runner Component");
	}

}
