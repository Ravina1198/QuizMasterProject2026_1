package com.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.test.entity.Student;

public  class DB_connection  {
	
	private static final String DB_Driver_ClassName="com.mysql.cj.jdbc.Driver";
	private static final String DB_URL="jdbc:mysql://localhost:3306/quiz_master";
	private static final String DB_USERNAME="root";
	private static final String DB_PASSWORD="newPassword";
//	private static final String Delete_Query= "Delete from students where id=1";
	private static final String INSERT_QUERY="insert into students(first_name, last_name, username, password, city, email, mobile) values(?,?,?,?,?,?,?)";
	
	public static Connection Getconnection() throws SQLException {
		Connection con=null;
		//PreparedStatement Ps=null;
		
		try {
			//step 1 . Load driver
			Class.forName(DB_Driver_ClassName);
			// step 2.  Establish connection
			 con=DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//con.close();
			//Ps.close();
		}
		return con;
	}
}
			
		
	

	


