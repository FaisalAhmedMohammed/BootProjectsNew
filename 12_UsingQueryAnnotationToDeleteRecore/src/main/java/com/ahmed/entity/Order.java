package com.ahmed.entity;

import java.time.LocalDate;
/*@Query annotation can also be used to perform insert/delete/update operations.
In this case, to mark that this query method is performing modifying operation,
 we should add @Modifying annotation.
 
JPA provider/ Hibernate can execute INSERT/DELETE/UPDATE operations with in a Database transaction only. 
If any problems occurs then jpa will roll back the transaction without modifying the data.
So, we should mark that method as transactional method with @Transactional annotation.
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
@Table(name = "NEWORDERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
