package com.ahmed.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.enity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
