
package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {

}
