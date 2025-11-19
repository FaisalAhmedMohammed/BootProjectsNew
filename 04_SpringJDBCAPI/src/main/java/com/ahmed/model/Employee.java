package com.ahmed.model;

public class Employee {

	private int empno;
	private String ename;
	private double sal;
	private int dept;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empno, String ename, double sal, int dept) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.dept = dept;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
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
		return "Employee [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", dept=" + dept + "]";
	}

}
