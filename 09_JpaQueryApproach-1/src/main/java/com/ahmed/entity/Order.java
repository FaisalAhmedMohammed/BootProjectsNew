package com.ahmed.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*•	We add a method declaration to our repository interface.
 * 
•	When we are working the findByMethod method name is very
 important because jpa will construct the query based on the method name and execute it .
 
•	Spring Data Jpa, will automatically generates a query based 
on method name, and it executes that query to return the entities.

•	The method name should follow a structure.
findBy or readBy or getBy + PropertyName + Condition(optional)
*/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NEWORDERS")
@ToString
public class Order {

	@Id
	@Column(name = "ORDER_ID")
	private Long orderId;

	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	@Column(name = "DATE_PURCHASED")
	private LocalDate datePurchased;

	@Column(name = "ORDER_STATUS")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

}
