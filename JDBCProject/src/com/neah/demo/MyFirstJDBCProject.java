package com.neah.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyFirstJDBCProject {

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement preparedStatement;
		
		
		try {
//			1. Connect
//			1.1 Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			1.2 Connect to the DataBase
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "DALtonENzo007!");
			
//			2. Query 
			preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE");
			
			//DQL : excecuteQuery(), which will result ResultSet
			ResultSet resultSet = preparedStatement.executeQuery();
			
//			3. Process the result
			while(resultSet.next()) {
				//read int type "employeeid" from employee table
				int id = resultSet.getInt("EMPLOYEEID");
				//read varchar type "name" column from employee table
				String name = resultSet.getString("NAME");
				//read varchar type "designation" column from employee table
				String desig=resultSet.getString("DESIGNATION");
				//read varchar type "department" column from employee table
				String deptt=resultSet.getString("DEPARTMENT");
				//read double type "salary" column from employee table
				double sal=resultSet.getDouble("SALARY");
				
				//displaying result  
				System.out.println(id+" "+name+" "+desig+" "+deptt+" "+sal);	
				
			}
			
			
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
