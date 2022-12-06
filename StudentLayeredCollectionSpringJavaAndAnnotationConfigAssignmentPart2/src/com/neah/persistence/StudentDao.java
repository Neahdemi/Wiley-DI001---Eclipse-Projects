package com.neah.persistence;

import java.util.Collection;

import com.neah.entity.Student;

/*
 * DAO : Data Access Object : Design Pattern to design persistence layer
 */
public interface StudentDao {
	
	Collection<Student>getAllRecords();
	Student searchRecord(int rollNo);
	Student insertRecord(Student student);

}
