package com.ahmed.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "NEW_EMP")
@Schema(description = "Employee  Model")
public class Employee {

	@Schema(description = "id of the employee ")
	@Id
	private Long empno;

	@Schema(description = "Name of the employee")
	private String ename;

	@Schema(description = "salary of the employee")
	private Double sal;

	@Schema(description = "departement of the employee")
	private Integer dept;

}
