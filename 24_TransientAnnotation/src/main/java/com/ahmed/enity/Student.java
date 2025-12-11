package com.ahmed.enity;

/*If the field does not contains column in the table we should mark that
 *  field with @Transient field
 *  
 *  Case 1: Entity has MORE variables than table columns
		(4 variables in entity → 3 columns in table)
✔ 		This is possible

 *  */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TRANSIANT_STUDENT")
public class Student {

	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "MARKS")
	private Double marks;

	@Transient
	@Column(name = "FINAL_RESULTS")
	private Character result;

}
