package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ahmed.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "UPDATE SAMPLE_EMPLOYEE SET sal =?,dept = ? WHERE empid = ?", nativeQuery = true)
	@Modifying
	@Transactional
	int updatePartial(Double sal, Integer dept, Integer empid);

}
