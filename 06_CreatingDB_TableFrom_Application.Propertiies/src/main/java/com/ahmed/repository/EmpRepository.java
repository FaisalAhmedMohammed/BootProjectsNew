package com.ahmed.repository;

import java.sql.RowId;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ahmed.model.Employee;

@Repository
public class EmpRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void save(Employee e) {
		jdbcTemplate.update("INSERT INTO NEWEMP VALUES(?,?,?,?)", e.getEmpno(), e.getName(), e.getSal(), e.getDept());
	}

	public void update(int empno, double sal) {
		jdbcTemplate.update("UPDATE NEWEMP SET SAL = ? WHERE EMPNO = ?", sal, empno);
	}

	public void delete(int empno) {
		jdbcTemplate.update("DELETE FROM NEWEMP WHERE EMPNO = ?", empno);
	}

	public void findById(int empno) {
		Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM NEWEMP WHERE EMPNO = ?", empno);
		map.forEach((k, v) -> System.out.println(k + " = " + v));
	}

	public void findAll() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT  * FROM NEWeMP");
		list.forEach(row -> {
			row.forEach((k, v) -> System.out.println(k + " = " + v));
			System.out.println("=".repeat(60));
		});
	}
}
