package com.ahmed.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "USERS")
public class User {
	
	@Id
	@TableGenerator(name = "genne",
					table ="mvc_gen", 
					pkColumnName = "gen_name",
					pkColumnValue = "gen_val",
					valueColumnName = "cust_id",
					allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "genne")
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private Long phno;

}
