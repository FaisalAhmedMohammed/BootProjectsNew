package com.ahmed.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmed.enity.Student;
import com.ahmed.repository.StudentRepository;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	@Override
	public void saveStudent(Student student) {
		repository.save(student);

	}

}
