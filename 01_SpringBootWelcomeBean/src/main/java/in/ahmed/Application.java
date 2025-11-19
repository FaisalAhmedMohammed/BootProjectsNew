package in.ahmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import in.ahmed.beans.SBHelloBean;

/*•	@SpringBootApplication represents that, this class is the entry point to execute the spring boot application.
•	A class with this @SpringBootApplication annotation, contains Java main () method.
•	Every spring boot application’s execution starts from main () method only.
•	A class with @SpringBootApplication is a Java configuration class. So, if any addition bean configurations are required, you can define them in this class.
•	In Spring Boot, a module is provided called spring-boot-autoconfigure module. 
•	This module goes to project class path, then identifies the starter dependencies added to the project and then defines all the default configurations required.
•	@EnableConfiguration annotation, enables this spring-boot-autoconfigure module’s support for the project.
•	@SpringBootApplication annotation also contains @ComponentScan. The process of identifying spring beans available in the application is called component scanning, so, by default, spring will start components auto scanning from the current package in which boot application class is available. Further, spring will also enters into its sub-packages.
•	In a Spring Boot project, the main class looks like below.
*/

@SpringBootApplication
public class Application {

	static SBHelloBean bean;

	public Application(SBHelloBean bean) {
		this.bean = bean;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		bean.sayHello();

	}

}
