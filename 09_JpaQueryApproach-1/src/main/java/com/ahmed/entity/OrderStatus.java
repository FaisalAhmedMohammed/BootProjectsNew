package com.ahmed.entity;

public enum OrderStatus {
	
	ORDERED("ordered"),//these are public static final variables we are writing in upper case(also called as class level constants)
	PROCESSED("processed"),//processed is the description  this description becomes values for this constants
	DELIVERED("delivered"),
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
