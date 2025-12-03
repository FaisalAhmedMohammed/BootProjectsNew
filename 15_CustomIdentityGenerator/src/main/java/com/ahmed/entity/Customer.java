package com.ahmed.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table
public class Customer {

	@Id
	@Column(name = "CUSTOMERID")
	@GenericGenerator(name = "customer-generator", strategy = "com.ahmed.generator.IdGenerator")
	@GeneratedValue(generator = "customer-generator")//attaching generator to primary key         
	private Long id;

	@Column(name = "CUSTOMERNAME")
	private String name;

	@Column(name = "PHONENO")
	private Long phNo;

}
