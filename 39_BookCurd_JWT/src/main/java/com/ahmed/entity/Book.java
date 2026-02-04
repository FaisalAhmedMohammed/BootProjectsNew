package com.ahmed.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "CrudBook")
@Data
public class Book {

	@Id
	private Integer id;

	private String title;

	private Double price;

}
