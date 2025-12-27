package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
