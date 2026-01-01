package com.ahmed.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SAMPLE_EMPLOYEE")

public class Employee {

	@Id
	private Integer empid;
	private String ename;
	private Double sal;
	private Integer dept;
}
