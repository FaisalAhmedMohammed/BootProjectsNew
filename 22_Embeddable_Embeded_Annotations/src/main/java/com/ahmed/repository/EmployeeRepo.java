package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ahmed.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	public Employee findByName(String name);

	/*
	 * UPDATE query cannot return Employee object. JPA only allows returning rows
	 * count.
	 */
	@Modifying
	@Transactional
	@Query("update  Employee e set e.address.street =?2 where e.empid =?1")
	int updateEmployee(Long empid, String street);

}
