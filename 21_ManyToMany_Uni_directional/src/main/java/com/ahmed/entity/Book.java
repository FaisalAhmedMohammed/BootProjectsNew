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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Table(name = "NEW_BOOKS")
public class Book {
	
	@Id
	@TableGenerator(name = "genbook",
					table = "book_Join",
					pkColumnName = "gen_name",
					valueColumnName = "gen_value",
					pkColumnValue = "bk_id",
					allocationSize = 1)
	
	@GeneratedValue(strategy =GenerationType.TABLE, generator = "genbook")
	@Column(name = "BOOK_ID")
	private Long id;
	
	@Column(name = "BOOK_NAME")
	private String name;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	
	@JoinTable(name = "JUNCTION",
	
				joinColumns = @JoinColumn(name ="BOOK_ID"),
				
				inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
	
	List<Author> authors = new ArrayList<>();

}
