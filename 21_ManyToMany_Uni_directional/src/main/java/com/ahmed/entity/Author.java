package com.ahmed.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "NEW_AUTHOR")
public class Author {
	
	@Id
	@Column(name = "AUTHOR_ID")
	@TableGenerator(name = "genauthor",
					table = "author_join",
					pkColumnName = "gen_name",
					valueColumnName = "gen_value",
					pkColumnValue = "at_id",
					allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "genauthor")
	private Long id;
	
	
	@Column(name = "AUTHOR_NAME")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authors")
	List<Book> books = new ArrayList<>();
	
	

}
