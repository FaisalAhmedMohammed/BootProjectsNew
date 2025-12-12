package com.ahmed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Person")
public class Person {

	@Id
	@TableGenerator(name = "gennew",
					table = "person_pas",
					pkColumnName = "gen_name",
					valueColumnName = "gen_value",
					pkColumnValue = "per_id",
					allocationSize = 1)
	
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "gennew")
	@Column(name = "PERSON_ID")
	private Long id;
	
	@Column(name = "PERSON_NAME")
	private String name;
	
	@Column(name = "GENDER")
	private Character gender;
	
	@Transient
	private String email;

}
