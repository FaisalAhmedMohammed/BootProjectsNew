package com.ahmed.entity;

/*if we want to define a value or a description to the constant then for that enum 
 * We need to define the private constructor to assign the value to a variable
 * For each constant this constructor will execute
 * --> to read the value of a constant we need to define a getter method 
 * --> we cannot define a setter method because each constant is a public static final variable */

public enum OrderStatus {
	
	ORDERED("ordered"),//these are public static final variables we are writing in upper case(also called as class level constants)
	PROCESSED("processed"),//processed is the description  this description becomes values for this constants
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
