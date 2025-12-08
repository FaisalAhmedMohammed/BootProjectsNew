package com.ahmed.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Employee")
public class Employee {
	
	@Id
	@TableGenerator(
		    name = "gen",
		    table = "employee_generator",
		    pkColumnName = "emp_name",
		    pkColumnValue = "dev_id",
		    valueColumnName = "emp_value",
		    allocationSize = 1
		)
		@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen")

	@Column(name = "EMPLOYEE_ID")
	private Long empid;
	
	@Column(name = "EMPLOYEE_NAME")
	private String ename;
	
	@Column(name = "SALARY")
	private double sal;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_add")
	List<Address> address = new ArrayList<>();
	

	

}
