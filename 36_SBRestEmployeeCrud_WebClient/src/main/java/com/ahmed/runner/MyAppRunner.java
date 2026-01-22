package com.ahmed.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.ahmed.model.Employee;
import com.ahmed.utils.UriUtils;

import reactor.core.publisher.Mono;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		WebClient webClient = WebClient.create();
								
		/* 
		 * this get employee with out handling exception
		  Mono<Employee> monoEmployee = webClient.get()
		        .uri(UriUtils.GET_EMP_BY_ID_URL, 7002)
		        .retrieve()              // it is used to retrieve the values or data from the url
		        .bodyToMono(Employee.class);  // this method will decode the body to given target type 
		
		monoEmployee.subscribe(employee -> System.out.println(employee));
		
		
		The above code will work good if there is no exception 
		what if the employee with the given id does not exist. then it produces string, but our pipeline returns employee mismatching type
		so exception throws

		*/
		
		Mono<Object> monoObj = webClient.get()
								.uri(UriUtils.GET_EMP_BY_ID_URL,12344)
								.exchangeToMono(response -> {   // it is alternative to response
								if(response.statusCode().is2xxSuccessful()) { // if the employee with id exist then return to employee type
									return response.bodyToMono(Employee.class);
								}
								else if (response.statusCode() == HttpStatus.NOT_FOUND) { // if employee does not exist then return string,here in server application we are returning string onlye
									return response.bodyToMono(String.class);
									
								}
								else {
									return Mono.error(new RuntimeException("unexcepted Error !!")) ;	
								}
								
								});
		
		monoObj.subscribe(result -> {
			System.out.println(result);
		});
		
		/*
		 * Flux<Employee> fluxEmployee = webClient.get()  // this flux is used to store all the elements coming from DB
		  						.uri(UriUtils.GET_ALL_EMPLOYEE_) 
		  						.retrieve()
		  						.bodyToFlux(Employee.class);
		  
		  fluxEmployee.subscribe(employee -> System.out.println(employee));  // this consumer will execute based on the elements 
		  																	if it contains 15 elements then 15 times consumer will execute
		 */
		 
		
		/*
	 Employee emp = new Employee();
	 emp.setEmpno(1111);
	 emp.setEname("Broad");
	 emp.setSal(50000.00);
	 emp.setDept(70);
	 
	 Mono<Employee> bodyToMono = webClient.post()   // post request
	 							.uri(UriUtils.ADD_EMPLOYEE)
	 							.contentType(MediaType.APPLICATION_JSON)   // optional, it is used to specify in which format request body is send to server
	 							.bodyValue(emp)                 // it is used to send the body in the request, and it is converted to JSON
	 							.retrieve()
	 							.bodyToMono(Employee.class);   // decode the body into employee type
	 
	 bodyToMono.subscribe(System.out::println);
	 
	 */
	 
		
		
		/*
	 Employee e = new Employee();
		e.setEmpno(101);
		e.setEname("kumar");
		e.setSal(35000.0);
		e.setDept(12);

		Mono<Employee> mono = webClient.put()
				.uri(UriUtils.UPDATE_EMPLOYEE) 
				.contentType(MediaType.APPLICATION_JSON)
				.bodyValue(e)
				.retrieve()
				.bodyToMono(Employee.class);

		mono.subscribe(System.out::println);

	 */
		
		
		/*
		Employee employee = new Employee();
		employee.setSal(75000.0);
		employee.setDept(100);
		
		 Mono<Employee>   monoEmp = webClient.patch()
				 					.uri(UriUtils.PARTIAL_UPDATE,7777)
				 					.contentType(MediaType.APPLICATION_JSON)
				 					.bodyValue(employee)
				 					.retrieve()
				 					.bodyToMono(Employee.class);
		 
		 monoEmp.subscribe(e -> System.out.println(e));
		 
		 */
		
		
		/*
		Mono<String> deleteMono = webClient.delete()
									.uri(UriUtils.DELETE_EMPLOYEE_BY_ID, 8808)
									.retrieve()
									.bodyToMono(String.class);
		
		deleteMono.subscribe(msg -> System.out.println("Response  : " + msg),
				 err -> System.err.println("ERROR: " + err.getMessage()));
				 
				 */
	 
	}
	

}
