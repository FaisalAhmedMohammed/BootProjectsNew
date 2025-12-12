package com.ahmed.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.entity.Passport;
import com.ahmed.entity.Person;
import com.ahmed.service.PersonService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	PersonService personService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// saveUser();
		// getPersonById(71L);

		getPasssortById(1L);

	}

	private void getPasssortById(long l) {

		Passport passport = personService.LoadPassportById(l);
		System.out.println(passport.getPassportId());
		System.out.println(passport.getIssuedAt());
		System.out.println(passport.getExpireAt());
		System.out.println(passport.getPerson().getId());
		System.out.println(passport.getPerson().getName());
		System.out.println(passport.getPerson().getGender());

	}

	private void getPersonById(long l) {
		Person ById = personService.LoadPersonById(l);
		System.out.println(ById.getId());
		System.out.println(ById.getName());
		// System.out.println(ById.getEmail());
		System.out.println(ById.getGender());

	}

	private void saveUser() {

		Person person = new Person();
		person.setName("ashok");
		person.setEmail("ashok@gmil.com");
		person.setGender('M');

		Passport passport = new Passport();
		passport.setIssuedAt(LocalDate.now());
		passport.setExpireAt(LocalDate.now().plusYears(15));

		personService.addPerson(person, passport);

	}

}
