package com.ahmed.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "NEW_EMP")
public class Employee implements Serializable{

	@Id
	private Long empno;

	private String ename;

	private Double sal;

	private Integer dept;

}
