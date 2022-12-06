package com.neah.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MySecondJDBCProject2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		
		try {
//			1. Connect
//			1.1 Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			1.2 Connect to the DataBase
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "DALtonENzo007!");
			
//			2. Query 
			preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?)");
			
			System.out.println("Enter Employee ID: ");
			preparedStatement.setInt(1, sc.nextInt());
			
			System.out.println("Enter Employee Name: ");
			preparedStatement.setString(2, sc.next());
			
			System.out.println("Enter Employee Designation: ");
			preparedStatement.setString(3, sc.next());
			
			System.out.println("Enter Employee Department: ");
			preparedStatement.setString(4, sc.next());
			
			System.out.println("Enter Employee Salary: ");
			preparedStatement.setDouble(5, sc.nextDouble());
			
//          DML : executeUpdate() , which will int (count of no of rows manipulated by the query)
			int rows = preparedStatement.executeUpdate();
			
//			3. Process the result
			if(rows>0)
				System.out.println("Employee added");
			else
				System.out.println("Employee Not added");
	
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//              4.close
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	

	}

}
