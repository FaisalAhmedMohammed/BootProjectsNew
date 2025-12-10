package com.ahmed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "CUSTOMER_LOAN")
public class CustomerLoan {

	@EmbeddedId // it is used to make this field is a composite key which contains two columns
				// as primary key
	// at this field with @EmbeddedId we cannot add @Column annotation
	private CustomerLoanId id;

	@Column(name = "CUSTOMER_NAME")
	private String name;

	@Column(name = "LOAN_PERIOD")
	private Integer period;

	@Column(name = "LOAN_TYPE")
	private String loanType;

}
