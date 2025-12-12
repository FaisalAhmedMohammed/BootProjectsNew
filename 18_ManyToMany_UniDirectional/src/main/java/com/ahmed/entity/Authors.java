package com.ahmed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUTHORS")
@Data
public class Authors {
	
	@Id
	@Column(name = "AUTHOR_NAME")
	@TableGenerator(name = "gener",
					table = "id_generator2",
					pkColumnName = "id_gen",
					valueColumnName = "gen_value",
					pkColumnValue = "book_author",
					allocationSize = 1)
	
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "gener")
	private Long id;
	
	@Column(name = "AUTHOT_NAME")
	private String name;

}
