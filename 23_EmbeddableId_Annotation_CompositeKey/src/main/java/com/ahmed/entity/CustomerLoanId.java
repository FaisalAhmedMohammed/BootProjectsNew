package com.ahmed.entity;

/*
 * @EmbeddedId is used to define a composite primary key (a primary key made of more than one column) in a JPA entity.
Instead of keeping multiple @Id fields inside an entity, 
we create a separate class that represents the primary key, and embed it into
 the entity.
*/
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerLoanId {

	@Column(name = "CUSTOMER_ID")
	private Long CustomerId;

	@Column(name = "LOAN_ID")
	private Long LoanId;

}
