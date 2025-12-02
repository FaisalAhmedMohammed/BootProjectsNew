package com.ahmed.entity;

import java.time.LocalDate;
/*@Query annotation: (Custom Query)
•	@Query annotation can be used to attach a query to the method declaration.
•	We can write our own query and we can ask data jpa to execute or query that is called as custom query
•	Here, we can add a custom method declaration to the repository interface and also we can attach a query to that method.
•	Here, the method declaration is no need to follow any structure.
•	This annotation in Spring Data JPA allows developers to define customer queries using JPQL or in SQL.
 
Status1 value will be set to the first?  And status2 value will be set to second?
•	JPQL – Java Persistence Query Language
•	SQL – Structured Query Language

•	JPQL queries looks like SQL queries. But in place of column names, we have to write (variables) property names and in place of table name, we have to write entity class reference.

•	If we write a JPQL query, it will be translated to a tuned SQL query and then that query will run on the database.

•	JPQL queries are database independent and they improve the application performance.


*	Here table name we have to replace with entity class reference variable name
	In place of * you have to write reference variable 
	Entity class columns name with entity class fields then this query is called jpa query.

*/
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "neworders")
public class Order {

	@Id
	@Column(name = "ORDER_ID")
	private Long orderId;

	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	@Column(name = "DATE_PURCHASED")
	private LocalDate datePurchased;

	@Enumerated(EnumType.STRING)
	@Column(name = "ORDER_STATUS")
	OrderStatus orderStatus;

}
