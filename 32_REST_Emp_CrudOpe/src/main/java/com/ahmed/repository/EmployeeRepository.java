package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ahmed.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "UPDATE NEW_EMP SET sal = ?, dept = ? WHERE empno = ?", nativeQuery = true)
	@Modifying
	@Transactional
	int partialUpdateEmployee(Double sal, Integer dept, Long empno);

}
