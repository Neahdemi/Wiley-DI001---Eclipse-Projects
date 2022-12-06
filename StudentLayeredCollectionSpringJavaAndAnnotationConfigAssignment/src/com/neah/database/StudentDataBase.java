package com.neah.database;

import java.util.LinkedHashMap;
import java.util.Map;

import com.neah.entity.Student;

/*
 * Mimicking the database: which later on we will going to change once we will do JDBC and MySql
 */
public class StudentDataBase {
	
	static private Map<Integer, Student> studentList = new LinkedHashMap<Integer, Student>();
	
	static {
			studentList.put(101, new Student(101, "Neah", 100));
			studentList.put(102, new Student(102, "Demi", 95));
			studentList.put(103, new Student(103, "George", 80));
			studentList.put(104, new Student(104, "Markos", 50));
			studentList.put(105, new Student(105, "Angelos", 65));
		
		
	}
	
	public static Map<Integer, Student> getStudentList(){
		return studentList;
	}

}
