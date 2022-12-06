package com.neah.service;

import java.util.Collection;

import com.neah.entity.Student;

public interface StudentService {
	
	Collection<Student> getAllStudents();
	
	Student searchStudentByRollNo(int rollNo);
	
	boolean addStudent(Student student);

}
