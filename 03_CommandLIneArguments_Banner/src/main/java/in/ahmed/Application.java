package in.ahmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.ahmed.beans.HelloBean;

@SpringBootApplication
public class Application {

	static HelloBean bean;

	public Application(HelloBean bean) {
		this.bean = bean;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		bean.sayHello();
	}

}
