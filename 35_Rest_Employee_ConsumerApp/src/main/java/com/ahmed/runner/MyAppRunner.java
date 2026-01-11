package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
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
		System.out.println(emp); // returning emp back to client application
		
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
		 @Param5 : values to set in URL variables
		 * */
		
		// calling exchange() method
		// this 2XX method will throw the exception at clent side like httpClentError | httpServeError to handle we have to use try and catch blocks
		
		/*here we are defining the statements in try and catch block
		 * because client application will throw the exceptions like httpClentError or httpServerError exception
		 * so to handle it we are using blocks*/
		ResponseEntity<?> re;
		try {
			re =restTemplate.exchange(ApplicatinUtils.GET_EMP_BY_ID_URL, HttpMethod.GET, null, Employee.class, 0001);
			HttpStatusCode status =  re.getStatusCode();
			if(status .is2xxSuccessful()) {
				Employee emp = (Employee)re.getBody();  // here Response entity will accept any type of object so when the status is successful then type cast it to employee object
				System.out.println(emp);
			}
		}
		catch (HttpClientErrorException  | HttpServerErrorException ex) {
		 re = new ResponseEntity<>(ex.getResponseBodyAsString(), ex.getStatusCode());
		 System.out.println("Error Response :");
		 System.out.println(re.getBody());
		 System.out.println("Status code : "+re.getStatusCode());
		}
		
		// this catch block to handle any type of exception
		
		catch(Exception ex) {
			System.err.println(ex);
		}
		// POSTing an Employee
		/*
		Employee emp = new Employee();// here we are post the employee in the request body so we need to create employee object 
		emp.setEmpno(717L); emp.setEname("Nisha"); emp.setSal(7000.0); emp.setDept(9);
		  
		// 
		HttpHeaders requestHeaders = new HttpHeaders();
		
		//HttpHeaders is used to send metadata along with the request.
 		//Headers tell the server how to process the request and response.
		
		requestHeaders.add("Content-Type", "application/xml");
		requestHeaders.add("Accept", "application/xml");
		
		HttpEntity<Employee> entity = new HttpEntity<Employee>(emp,requestHeaders);// this class HttpEntity has constructor and pass //
		//the object this(emp) object i am passing and it will be converted to "content-type" is nothing but json and send to the client
		
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
		*/
	}
	
	}
/*Consumer App
    ↓
Create Employee Object
    ↓
Add Headers
    ↓
Wrap into HttpEntity
    ↓
POST request via RestTemplate.exchange()
    ↓
Provider App
    ↓
ResponseEntity<Employee>
    ↓
Check status → Read body


Call Provider using exchange()
ResponseEntity<Employee> re =
    restTemplate.exchange(
        ApplicatinUtils.POST_EMP_OBJ_,
        HttpMethod.POST,
        entity,
        Employee.class
    );

What happens here?

exchange() sends the HTTP request to the provider.

It is the most powerful method of RestTemplate.

Parameters:

URL

ApplicatinUtils.POST_EMP_OBJ_


→ Endpoint of provider application

HTTP Method

HttpMethod.POST


→ Sending data to server

Request Entity

entity


→ Contains body + headers

Response Type

Employee.class


→ Response body will be converted to Employee object

5️⃣ Get HTTP Status Code
HttpStatusCode status = re.getStatusCode();


Extracts HTTP status code from response.

Examples:

200 OK

201 CREATED

409 CONFLICT

400 BAD REQUEST
*/
