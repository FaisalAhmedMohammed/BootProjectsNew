package com.ahmed.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
