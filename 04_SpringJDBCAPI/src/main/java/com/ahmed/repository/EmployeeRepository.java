package com.ahmed.repository;
/** JDBC: Java Database Connectivity
* JDBC is a technology which could be used to connect a Java application with a Database, to perform CRUD operations.
To connect java application with data base we need jdbc driver
* JDBC Driver is a software, which makes Java Environment and Database Environment to work together.

  * If we directly use JDBC API in an application, we are going get the below issues.
 1. boiler-plate code problem.
 2. memory-leak problem.
 3. Handling the exceptions (checked)
•	Boiler plate code means, repeated code like load the driver, establish a connection, create a statement, close the connection, etc...
•	If you do not clean up the connection objects or statement objects properly, then memory leak problem will occur.
•	In every method, where a Jdbc code is written, you have to handle the exceptions with try and catch blocks.

•	To avoid these issues, Spring Framework has provided Spring JDBC module and this module has an important class called “JdbcTemplate” class.

•	JdbcTemplate class will internally take care of the above issues, and as a developer, we are going to use JdbcTemplate class to execute the SQL queries (perform crud operations).

•	When you are creating a repository class, you have to use JdbcTemplate class object as dependency object.
*/
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ahmed.model.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	JdbcTemplate jdTemplete;

	public void save(Employee e) {
		jdTemplete.update("INSERT INTO EMP VALUES (?,?,?,?)", e.getEmpno(), e.getEname(), e.getSal(), e.getDept());
	}

	public void findById(int empno) {
		Map<String, Object> map = jdTemplete.queryForMap("SELECT * FROM EMP WHERE EMPNO = ?", empno);
		map.forEach((k, v) -> System.out.println(k + " " + v));
	}

	public void update(int empno, double sal) {
		jdTemplete.update("UPDATE EMP SET SAL= ? WHERE EMPNO = ?", sal, empno);
	}

	public void delete(int empno) {
		jdTemplete.update("DELETE FROM EMP WHERE EMPNO = ? ", empno);
	}

	public void getAll() {
		List<Map<String, Object>> maps = jdTemplete.queryForList("SELECT * FROM EMP");
		maps.forEach(row -> {
			row.forEach((k, v) -> System.out.println(k + " = " + v));
			System.out.println("----------------------------");
		});

	}

}
