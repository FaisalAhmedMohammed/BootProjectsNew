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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Table(name = "NEW_EMPLOYEE")
public class Employee {

	@Id
	@TableGenerator(name = "Empgen", 
					table = "bi_directional", 
					pkColumnName = "gen_name",
					pkColumnValue = "cus_id",
					valueColumnName = "gen_value", 
					allocationSize = 1)

	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Empgen")
	@Column(name = "EMPLOYEE_ID")
	private Long empid;

	@Column(name = "EMPLOYEE_NAME")
	private String ename;

	@Column(name = "SALARY")
	private Double sal;

	@Override
	public String toString() {
	    return "Employee{" +
	            "empid=" + empid +
	            ", ename='" + ename + '\'' +
	            ", sal=" + sal +
	            '}';
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "employee")
	List<Address> addresses = new ArrayList<>();

}
