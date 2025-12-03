package com.ahmed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
/*Uses a separate table to store and generate unique primary key values.
•	 The table maintains a counter, similar to sequences, but is implemented at the application level.
•	Works with databases that don’t support sequences or auto increment.
•	To use this strategy, first we need to create a id generator table in the database and insert one record like below.
CREATE TABLE id_generator (
    gen_name VARCHAR(50) PRIMARY KEY,
    gen_value LONG
);
*/
@Entity
@Data
@NoArgsConstructor
@Table(name = "CUSTOMERS")
public class Customer {
	
	@Id
	@TableGenerator(name = "gen3",
					table = "generator",
					pkColumnName = "gen_id",
					valueColumnName = "gen_val",
					pkColumnValue = "cust_id",
					allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE,
					generator = "gen3")
	
	@Column(name = "CUSTOMERID")
	private Long id;
	
	@Column(name = "CUSTOMERNAME")
	private String name;
	
	@Column(name = "PHONENO")
	private Long phNo;

}
