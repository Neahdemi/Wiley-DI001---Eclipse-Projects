package com.neah.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.neah.entity.Student;
import com.neah.persistence.StudentDao;


public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;

	public StudentServiceImpl(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	@Override
	public Collection<Student> getAllStudents() {
		return studentDao.getAllRecords();
	}

	@Override
	public Student searchStudentByRollNo(int rollNo) {
		return studentDao.searchRecord(rollNo);
	}

	@Override
	public boolean addStudent(Student student) {
		Student stud =studentDao.searchRecord(student.getRollNo());
		if(stud!=null) {
			return false;
		}
		studentDao.insertRecord(student);
		return true;
	}

}
