package com.ahmed.service;
/*•	Spring JDBC API has provided SimpleJdbcCall class to invoke a procedure
 *  or a function of a database.
•	In a database we can define a procedure or a function to implement 
a task/logic.
•	A Java application can call that procedure/function, so that the task
 will be completed in a single trip (single network call) to the database.
•	This will reduce the trips b/w application and database and can
 enhance the performance of an application.
•	When we add spring-boot-starter-jdbc dependency, the spring boot 
will auto configure JdbcTemplate class into the container, but not 
SimpleJdbcCall.
•	So, we need to explicitly configure SimpleJdbcCall class, in a 
configuration class, by creating a @Bean method.
•	Here I am going to create a function with the name return bonus (empid)
•	It calculates	 the bonus based on the salary of the employee and 
return the bonus
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.repository.EmpRepository;

@Service
public class EmpSerivce {
	
	@Autowired
	EmpRepository empRepository;
	
	public void callinFunction(int empno) {
		empRepository.callFunction(empno);
		System.out.println("Function is Called ");
	}

}
