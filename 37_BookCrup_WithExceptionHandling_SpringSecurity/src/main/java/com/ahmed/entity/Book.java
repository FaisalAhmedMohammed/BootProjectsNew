package com.ahmed.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "CrudBook")
@Data
public class Book {

	@Id
	@Schema(description = "Unique Id of the Employee ", example = "1001")
	private Integer id;
	
	@Schema(description = "Title to be given to the book")
	private String title;
	
	@Schema(description = "Price of the Book in Rupees")
	private Double price;

}
