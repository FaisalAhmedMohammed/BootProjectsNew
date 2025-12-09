package com.ahmed.repostitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ahmed.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	@Modifying
	@Transactional
	@Query("delete from Employee e where e.ename = ?1")
	int removeEmployee(String ename);// return type is int 
	
	

}
