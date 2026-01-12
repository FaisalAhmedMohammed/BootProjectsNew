package com.ahmed.model;

public class Employee {

    private Integer empno;
    private String ename;
    private Double sal;
    private Integer dept;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee [empno=" + empno + ", ename=" + ename +
               ", sal=" + sal + ", dept=" + dept + "]";
    }
}
