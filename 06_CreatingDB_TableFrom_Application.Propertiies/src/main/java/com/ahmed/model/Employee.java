package com.ahmed.model;

public class Employee {

	private int empno;
	private String name;
	private double sal;
	private int dept;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empno, String name, double sal, int dept) {
		super();
		this.empno = empno;
		this.name = name;
		this.sal = sal;
		this.dept = dept;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", sal=" + sal + ", dept=" + dept + "]";
	}

}
