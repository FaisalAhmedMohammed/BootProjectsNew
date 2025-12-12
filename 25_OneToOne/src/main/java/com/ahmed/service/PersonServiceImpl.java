package com.ahmed.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.entity.Passport;
import com.ahmed.entity.Person;
import com.ahmed.repository.PassportRepo;
import com.ahmed.repository.PersonRepo;

@Service(value = "personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepo personRepo;

	@Autowired
	PassportRepo passportRepo;

	@Override
	public Person addPerson(Person person, Passport passport) {
		passport.setPerson(person);// setting person to passport
		passportRepo.save(passport); // and saving the passport
		return person; // saving the person
	}

	@Override
	public Person LoadPersonById(Long id) {

		Optional<Person> byId = personRepo.findById(id);
		if (byId.isPresent()) {
			Person person = byId.get();
			return person;
		}
		return null;
	}

	@Override
	public Passport LoadPassportById(Long passportId) {

		Optional<Passport> byId = passportRepo.findById(passportId);
		if (byId.isPresent()) {
			Passport passport = byId.get();

			return passport;
		}
		return null;

	}

}
