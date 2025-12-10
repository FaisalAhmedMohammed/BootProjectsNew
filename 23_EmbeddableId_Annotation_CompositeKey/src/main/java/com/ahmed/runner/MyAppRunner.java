package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.entity.CustomerLoan;
import com.ahmed.entity.CustomerLoanId;
import com.ahmed.service.CustomerLoanService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	CustomerLoanService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		saveLoan();
	}

	private void saveLoan() {

		// first created Embeddable class object and setting the data CustomerLoanId
		CustomerLoanId id = new CustomerLoanId();
		id.setCustomerId(101L);
		id.setLoanId(90991L);

		// create customer loan object
		CustomerLoan loan = new CustomerLoan();

		loan.setId(id);
		loan.setName("VIJAY");
		loan.setLoanType("VEHICLE");
		loan.setPeriod(24);

		// service.saveCustomerWithId(loan);// saving first customer loan

		// first created Embeddable class object and setting the data
		CustomerLoanId id2 = new CustomerLoanId();
		id2.setCustomerId(101L);
		id2.setLoanId(90981L);

		CustomerLoan loan2 = new CustomerLoan();

		loan2.setId(id2);
		loan2.setName("VIJAY");
		loan2.setLoanType("PERSONAL");
		loan2.setPeriod(48);

		service.saveCustomerWithId(loan2);

	}

}
