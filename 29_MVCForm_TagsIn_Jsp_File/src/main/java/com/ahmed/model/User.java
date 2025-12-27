package com.ahmed.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class User {

	@NotBlank
	private String username;

	@NotBlank
	@Email
	private String email;

	@Pattern(regexp = "\\d{10}")
	private String mobile;

	@NotEmpty
	private String gender;

	@Past
	@NotNull
	private LocalDate dob;

}
