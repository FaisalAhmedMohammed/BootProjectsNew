package com.ahmed.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ORDERS")
public class Order {

	@Id
	@Column(name = "ORDER_ID")
	private Long orderId;

	@Column(name = "DATE_PURCHASED")
	private LocalDate datePurchased;

	@Column(name = "ORDER_STATUS")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // here we are marking that this filed is created to
																	// define many to one relation ship
	@JoinColumn(name = "CUSTOMER_ID")
	Customer customer;

}
