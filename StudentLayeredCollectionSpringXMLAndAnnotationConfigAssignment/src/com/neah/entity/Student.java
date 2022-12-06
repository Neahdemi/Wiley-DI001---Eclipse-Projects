package com.neah.entity;


/*
 * Student class : rollNo, Name, grade
List all students, add new student
4 solutions: java config, java and annotation, xml config, xml and annotation config
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

	private int rollNo;
	private String studentName;
	private int studentGrade;
	
}