package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ahmed.entity.Employee;
import com.ahmed.util.ApplicatinUtils;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*
		//calling getForObject method which return only object
		// Employee.class represents the responseType in which is class object we need to store Employee data
		Employee emp = restTemplate.getForObject(ApplicatinUtils.GET_EMP_BY_ID_URL, Employee.class, 6004);
		System.out.println("Employee fetched form the Provider is :");
		System.out.println(emp);
		
		*/
		// calling getForEntity which returns 
		//Body(actual data)
		//HTTP status code
		//HTTP headers
		/* then checking the status code if status code is 2x which is success
		 * then getting the body and printing*/
		
		/*
		ResponseEntity<Employee> re = restTemplate.getForEntity(ApplicatinUtils.GET_EMP_BY_ID_URL, Employee.class, 7001);
		
		HttpStatusCode status = re.getStatusCode();
		if(status .is2xxSuccessful()) {
		Employee emp = re.getBody();
		System.out.println(emp);
		}
		*/
		
		
		//calling exchange() method
		/* 
		 @param1 : request URL
		 @param2 : HttpRequest method (get, post, put, patch)
		 @Param3 : request entity (used to send an object in the request body)
		 @param4 : response type
		 @Param5 : values to set in uri variables
		 * */
		
		// calling exchange() method
		/*
		ResponseEntity<Employee> re = restTemplate.exchange(ApplicatinUtils.GET_EMP_BY_ID_URL, HttpMethod.GET, null, Employee.class, 7001);
		HttpStatusCode status =  re.getStatusCode();
		if(status .is2xxSuccessful()) {
			Employee emp = re.getBody();
			System.out.println(emp);
		}
		*/
		
		// POSTing an Employee
		
		Employee emp = new Employee();// here we are post the employee in the request body so we need to create employee object 
		emp.setEmpno(8808L); emp.setEname("raju"); emp.setSal(30000.0); emp.setDept(30);
		  
		// 
		HttpHeaders requestHeaders = new HttpHeaders();
		
		requestHeaders.add("Content-Type", "application/json");
		requestHeaders.add("Accept", "application/xml");
		
		HttpEntity<Employee> entity = new HttpEntity<Employee>(emp,requestHeaders);// this class HttpEntity has constructor and pass the object
		
		ResponseEntity<Employee> re = restTemplate.exchange(ApplicatinUtils.POST_EMP_OBJ_, HttpMethod.POST, entity, Employee.class);
		
		HttpStatusCode status = re.getStatusCode();
		
		if(status.is4xxClientError()) {
			System.out.println("Conflict Duplicate Employee found");
		}
		else {
			Employee employee = re.getBody();
				System.out.println("Employee is Created into the DataBase");
				System.out.println("Employee Details are");
				System.out.println(employee);
				
				
			}
		}
	
	}

