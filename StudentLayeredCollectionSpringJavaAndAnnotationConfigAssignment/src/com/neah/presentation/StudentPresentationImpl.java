package com.neah.presentation;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neah.entity.Student;
import com.neah.service.StudentService;

@Component("stuPresentation")
public class StudentPresentationImpl implements StudentPresentation {
	
	private StudentService studentService;
	
	
	@Autowired
	public StudentPresentationImpl(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("Student Management System");
		System.out.println("1. List All Students");
		System.out.println("2. Search Student By Roll Number");
		System.out.println("3. Add New Student");
		System.out.println("4. Exit");
		System.out.println("============================");
		
	}

	@Override
	public void performMenu(int choice) {
		Scanner sc = new Scanner(System.in);
		
		switch(choice) {
		
		case 1:
			Collection<Student> students=studentService.getAllStudents();
			for(Student stud:students) {
				System.out.println(stud);
			}
			break;
		case 2:
			System.out.println("Enter Student Roll Number : ");
			int rollNo=sc.nextInt();
			Student student=studentService.searchStudentByRollNo(rollNo);
			if(student!=null)
				System.out.println(student);
			else
				System.out.println("Student with roll number "+rollNo+" does not exist");
			break;
		case 3:
			Student newStudent = new Student();
			
			System.out.println("Enter Student Roll number: ");
			newStudent.setRollNo(sc.nextInt());
			System.out.println("Enter Student Name: ");
			newStudent.setStudentName(sc.next());
			System.out.println("Enter Student Grade: ");
			newStudent.setStudentGrade(sc.nextInt());
			
			if(studentService.addStudent(newStudent))
				System.out.println("Student Record Added");
			else
				System.out.println("Student with roll number "+newStudent.getRollNo()+" already exists, so cannot add it as a new student!");
			break;	
		case 4:
			System.out.println("Thanks for using Student Management System");
			System.exit(0);
		default:
			System.out.println("Invalid Choice!");
			break;
		
		}
		
	}

}
