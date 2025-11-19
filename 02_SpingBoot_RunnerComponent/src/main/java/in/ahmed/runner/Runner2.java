package in.ahmed.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class Runner2 implements ApplicationRunner{
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("This is Runner 2 Task");
		
	}

}
