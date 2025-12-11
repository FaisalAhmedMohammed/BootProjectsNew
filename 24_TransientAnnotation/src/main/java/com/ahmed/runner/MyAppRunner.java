package com.ahmed.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ahmed.enity.Student;
import com.ahmed.service.StudentService;

@Component
public class MyAppRunner implements ApplicationRunner {

	@Autowired
	StudentService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		saveStudent();
	}

	private void saveStudent() {

		Student student = new Student();
		student.setName("SOPHIA");
		student.setMarks(89.0);

		service.saveStudent(student);
		
		Student student2 = new Student();
		student2.setName("MILLER");
		student2.setMarks(95.0);


	}

}
