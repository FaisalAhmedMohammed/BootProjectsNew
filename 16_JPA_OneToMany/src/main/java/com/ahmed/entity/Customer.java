package com.ahmed.entity;

/*•	One-to-many relationship can be provided to navigate from a parent entity to its child entities.
•	For example, we can provide one-to-many mapping from customer to his orders. So that, we can navigate from a customer to see his orders.
•	To provide one-to-many relationship, the parent class should have a collection reference, to hold the child class objects.
•	For example, in Customer class, you need a List<Order> to hold the orders of a customer.
*/
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
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@TableGenerator(name = "gen", table = "id_generator", pkColumnName = "gen_name", valueColumnName = "gen_value", pkColumnValue = "cus_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen")
	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	@Column(name = "CUSTOMER_NAME")
	private String name;

	@Column(name = "PHONE_NO")
	private Long phNo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMER_ID") // Specifying Foreign key column
	List<Order> orders = new ArrayList<>();

}
