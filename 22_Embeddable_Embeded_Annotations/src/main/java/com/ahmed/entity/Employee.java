package com.ahmed.entity;

/*
 * In JPA (Java Persistence API), a @Embeddable class is a reusable piece of data that you can embed inside entities, rather than treat as a separate table.

It does not have its own table or primary key.

It's stored as part of the owning entity's table.

@Embeddable	Marks a class whose fields can be embedded in other entity classes
        @Embedded – Placed in an entity to tell JPA to include the fields of the       embeddable class as part of this entity’s table.
		No @Id	Embeddable don’t have primary keys.
*/
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor

@Data
@Table(name = "Employee_Address_Embeded")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empid;

	private String name;

	private String email;

	private Double salary;

	@Embedded // this annotation tells jpa to add the fields of address to include in this
				// entity class object
	private Address address;

}
