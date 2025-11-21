package com.ahmed.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepository {

	@Autowired
	SimpleJdbcCall call;

	public void callFunction(int empno) {
		call.withFunctionName("salary_hike");

		Map<String, Object> execute = call.execute(empno);
		execute.forEach((k, v) -> System.out.println(k + " = " + v));
	}

}
