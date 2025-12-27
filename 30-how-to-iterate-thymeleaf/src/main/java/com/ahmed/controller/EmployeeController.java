package com.ahmed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahmed.entity.Employee;
import com.ahmed.service.EmployeeService;

@Controller(value = "employeeController")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping(value = "/index")
	public String getIndexPage() {
		return "index";

	}

	@GetMapping(value = "/views")
	public String viewEmployees(@RequestParam(defaultValue = "0") int page, Model model) {// default page no is 0
																							// whenever the client sends
																							// the request first 0 page
																							// is displayed with records

		int size = 5;
		Page<Employee> fetchAllEmPage = empService.FetchAllEmp(page, size);// page object it contains how many
		// records,current page, it has previous page or not or it has a
		// next page or not, totally how many pages are there
		model.addAttribute("employees", fetchAllEmPage.getContent()); // it contains list<Employess> sharing to view
		model.addAttribute("currentPage", page); // it returns current page if i know the current
													// page then only next page will be current +1,
													// or previous -1;
		model.addAttribute("hasNext", fetchAllEmPage.hasNext()); // to verify next page available or not
		model.addAttribute("hasPrevious", fetchAllEmPage.hasPrevious()); // to verify previous page or not
		return "views";

	}

}
