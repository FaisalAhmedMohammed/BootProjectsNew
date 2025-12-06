package com.ahmed.entity;

/*•	One-to-many bi direction is a combination of one-to-many along with many-to-one 
 * from the other side.
 * 
•	With bi-direction, you can navigate from parent to child objects and also from
 a child to its parent object.
 
•	To connect a child object with its parent object, in child entity class, you
 should create a reference to parent class, and mark it as a many-to-one field.
 
•	The joincolumn is specified with @ManyToOne, and mappedBy attribute is used 
with @OneToMany.
•	The mappedBy attribute in the @OneToMany annotation is used to specify the 
inverse side of a bidirectional relationship. It tells JPA that this entity does 
not own the relationship and that the foreign key mapping is handled by the other
 entity.
 
•	The field inside mappedBy must match the variable name in the owning entity.
•	The owning side (with @ManyToOne) manages the relationship, while the inverse side (with @OneToMany(mappedBy)) just reads it.
*/
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	@TableGenerator(name = "gen3",
					table = "id_generator", 
					pkColumnName = "gen_name", 
					valueColumnName = "gen_val", 
					allocationSize = 1)

	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gen3")
	private Long id;

	@Column(name = "CUSTOMER_NAME")
	private String name;

	@Column(name = "PHONE_NUMBER")
	private Long phNo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	List<Order> orders = new ArrayList<>();

}
