package com.ahmed.entity;

import java.time.LocalDate;

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
@Table(name = "ORDERS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

	@Id
	@Column(name = "ORDER_ID")
	private Long orderId;

	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	@Column(name = "DATE_PURCHASED")
	private LocalDate datePurchased;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "ORDER_STATUS")
	private OrderStatus orderStatus;

}
