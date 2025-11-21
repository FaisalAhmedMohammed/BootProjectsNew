package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.service.EmpSerivce;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	EmpSerivce empSerivce;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		empSerivce.callinFunction(1234);

	}
}
