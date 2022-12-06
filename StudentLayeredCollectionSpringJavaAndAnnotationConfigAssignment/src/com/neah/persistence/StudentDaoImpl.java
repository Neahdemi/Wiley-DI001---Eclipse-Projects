package com.neah.persistence;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.neah.database.StudentDataBase;
import com.neah.entity.Student;

/*
 * If we don't specify component name,
 * then component name will be same as that of class name but in camelCase
 */
@Component("dao")
public class StudentDaoImpl implements StudentDao {

	@Override
	public Collection<Student> getAllRecords() {
		return StudentDataBase.getStudentList().values();
	}

	@Override
	public Student searchRecord(int rollNo) {
		return StudentDataBase.getStudentList().get(rollNo);
	}

	@Override
	public Student insertRecord(Student student) {
		return StudentDataBase.getStudentList().put(student.getRollNo(), student);
				
	}

}
