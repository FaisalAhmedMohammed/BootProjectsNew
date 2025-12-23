package com.ahmed.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

@Data
public class Employee {

	@NotNull
	private Long empno;

	@NotBlank
	private String ename;

	@NotNull
	private Double sal;

	@NotNull
	private Integer dept;

	@Past
	@NotNull
	private LocalDate dob;

}
