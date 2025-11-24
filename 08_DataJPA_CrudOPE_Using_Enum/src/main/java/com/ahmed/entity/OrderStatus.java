package com.ahmed.entity;

public enum OrderStatus {
	
	ORDERED("ordered"),
	PROCESSED("processed"),
	DELIVERED("delivered"),
	REFUNDED("refunded"),
	CANCELED("canceled");
	
	private String value;

	private OrderStatus(String value) {
		this.value = value;
	}

	public void getValue(String value) {
		this.value = value;
	}
	
	

}
