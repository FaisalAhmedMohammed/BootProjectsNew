package com.ahmed.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ahmed.entity.Address;
import com.ahmed.entity.Employee;
import com.ahmed.service.EmployeeService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	EmployeeService employeeService;

	@Transactional
	@Override
	public void run(ApplicationArguments args) throws Exception {

		// saveEmployee();
		FetchEmployee(501L);
		// deleteEmployee("SOPHIA");

		fetchAddress(1L);
	}

	private void fetchAddress(long l) {
		Address byId = employeeService.loadById(l);
		System.out.println(byId);

	}

	private void deleteEmployee(String name) {

		boolean deleteEmp = employeeService.deleteEmp(name);
		if (!deleteEmp) {
			System.out.println("Employee with name '" + name + "' does not exist!");
		} else {
			System.out.println("Employee deleted successfully!");
		}

	}

	private void FetchEmployee(Long l) {
		Employee employee = employeeService.loadEmployee(l);
		System.out.println("Employee Id :" + employee.getEmpid());
		System.out.println("Employee Name :" + employee.getEname());
		System.out.println("Employee Salary :" + employee.getSal());

		System.out.println("Fetching Child (Address) based on demand");

		List<Address> addresses = employee.getAddresses();
		addresses.forEach(System.out::println);

	}

	private void saveEmployee() {
		Employee emp1 = new Employee();
		emp1.setEname("ADAM");
		emp1.setSal(9000.0);

		Address add1 = new Address();
		add1.setCity("HYDERABD");
		add1.setState("TELANGANE");
		add1.setType("TEMPORARY");
		add1.setPincode(709001L);

		Address add2 = new Address();
		add2.setCity("NEW_STREET");
		add2.setState("SYDNEY");
		add2.setType("PERMENEMT");
		add2.setPincode(55001L);

		// Child should know parent
		add1.setEmployee(emp1);// setting means knowing
		add2.setEmployee(emp1);

		// Parent should know all child addresses
		List<Address> list = Arrays.asList(add1, add2);
		emp1.setAddresses(list);

		// Finally save parent -> cascade will save address
		employeeService.saveEmployee(emp1);

		System.out.println("Employee Address is inserted In Data base");
		System.out.println(emp1.getEmpid());

	}

}
