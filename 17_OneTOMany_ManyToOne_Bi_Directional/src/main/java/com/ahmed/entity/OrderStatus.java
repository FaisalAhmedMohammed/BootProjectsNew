package com.ahmed.entity;

public enum OrderStatus {
	
	Ordered("ordered"),
	PROCESSED("processed"),
	DELIVERED("delivered"),
	PURCHASED("purchased"),
	REFUNDED("refunded"),
	CANCELED("canceled");
	
	private String value;
	
	private OrderStatus(String value) {
		this.value=value;	
	}
	public String getValue() {
		return value;
	}
	
	
}
