package com.ahmed.service;

import com.ahmed.entity.Passport;
import com.ahmed.entity.Person;

public interface PersonService {

	Person addPerson(Person person, Passport passport);

	Person LoadPersonById(Long id);

	Passport LoadPassportById(Long passportId);

}
