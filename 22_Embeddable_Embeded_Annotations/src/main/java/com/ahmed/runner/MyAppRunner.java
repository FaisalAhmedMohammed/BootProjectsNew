package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.entity.Address;
import com.ahmed.entity.Employee;
import com.ahmed.service.EmployeeService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	EmployeeService employeeService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// saveEmployee();

		 loadEmployee("ashok");

		//replaceEmployee(1L, "Hitech City");

	}

	private void replaceEmployee(long l, String string) {

		employeeService.updateEmployeeAddress(l, string);

	}

	private void loadEmployee(String string) {

		Employee employee = employeeService.getEmployee(string);
		System.out.println(employee.getEmpid());
		System.out.println(employee.getName());
		System.out.println(employee.getSalary());
		System.out.println(employee.getEmail());
		System.out.println(employee.getAddress().getHouseNo());
		System.out.println(employee.getAddress().getStreet());
		System.out.println(employee.getAddress().getCity());
		System.out.println(employee.getAddress().getPincode());

	}

	private void saveEmployee() {

		Address address = new Address("1-1-218", "Mallapelly", "Hyderabad", 503006);

		Employee employee = new Employee();
		employee.setName("ashok");
		employee.setEmail("ashok@gamil.com");
		employee.setSalary(89000.0);
		employee.setAddress(address);

		employeeService.addEmployee(employee);
		System.out.println("Employee Saved In Saved With Address");

	}

}
