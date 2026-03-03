package com.test.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.database.connection.DB_connection;
import com.test.entity.Student;

public  class InsertData  {
	
	private static final String DB_Driver_ClassName="com.mysql.cj.jdbc.Driver";
	private static final String DB_URL="jdbc:mysql://localhost:3306/quiz_master";
	private static final String DB_USERNAME="root";
	private static final String DB_PASSWORD="newPassword";
//	private static final String Delete_Query= "Delete from students where id=1";
	private static final String INSERT_QUERY="insert into students(first_name, last_name, username, password, city, email, mobile) values(?,?,?,?,?,?,?)";
	
	public static boolean getUserinput(Student student) throws SQLException, ClassNotFoundException {
		Connection con=null;
		PreparedStatement Ps=null;
		
		try {
			DB_connection.Getconnection();
			
			 Ps =con.prepareStatement(INSERT_QUERY);
			//step 4 : execute query
			Ps.setString(1,student.getFirstName());
			Ps.setString(2,student.getLastName());
			Ps.setString(3,student.getUsername());
			Ps.setString(4,student.getPassword());
			Ps.setString(5,student.getCity());
			Ps.setString(6,student.getEmail());
			Ps.setString(7,student.getMobileNumber());
			//step 5: execute update
			try {
				int result=Ps.executeUpdate();
				
				return result>0;
				
			}
			catch(java.sql.SQLIntegrityConstraintViolationException e){
				System.out.println(" Error: Username or Email already exists in our system.");
			    return false;
			}
			
			
		
		
		}finally {
			con.close();
			Ps.close();
		}
			
		
	} 
		
	}

	


