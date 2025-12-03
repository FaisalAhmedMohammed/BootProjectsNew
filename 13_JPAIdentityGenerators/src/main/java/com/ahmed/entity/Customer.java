package com.ahmed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {

	@Id
	@Column(name = "ID")
	// @GeneratedValue(strategy = GenerationType.IDENTITY)

	// @SequenceGenerator(name = "gen1", sequenceName = "customer_seq",
	// allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen1")

	@TableGenerator(name = "gen2", 
					table = "id_generator",
					pkColumnName = "gen_id",
					valueColumnName = "gen_val",
					pkColumnValue = "cust_id",
					allocationSize = 1)
	
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "gen2")
	private Long id;

	@Column(name = "CUSTOMERNAME")
	private String name;

	@Column(name = "PHONENO")
	private Long phoneNo;

}
