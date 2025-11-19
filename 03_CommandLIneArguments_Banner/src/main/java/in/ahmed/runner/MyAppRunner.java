package in.ahmed.runner;

import java.util.List;

import javax.annotation.processing.SupportedSourceVersion;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component

public class MyAppRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("This is Runner component ");

		if (args.containsOption("user.name")) {

			List<String> optionValues = args.getOptionValues("user.name");
			if (optionValues.get(0).equals("ahmed")) {
				System.out.println("user name is valid");
			} else {
				System.out.println("invalid user name");
			}

		}
		else {
			System.out.println("user name is invalid");
		}

	}
}
