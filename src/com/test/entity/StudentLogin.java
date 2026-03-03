package com.test.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.connection.DB_connection;

public class StudentLogin  {
	private static final String DB_Driver_ClassName="com.mysql.cj.jdbc.Driver";
	private static final String DB_URL="jdbc:mysql://localhost:3306/quiz_master";
	private static final String DB_USERNAME="root";
	private static final String DB_PASSWORD="newPassword";
	private static final String loginQuery="select * from students Where username = ? AND password = ?";
	
	public static boolean loginStudent(String username, String password) throws SQLException {
	    //Connection con = null;
	    
	    ResultSet rs = null;
	    boolean status = false;

	    try {
	    	Connection con= DB_connection.Getconnection();
	        
	        // Query to check if the user exists with the given password
	       
	        PreparedStatement Ps = con.prepareStatement(loginQuery);
	        Ps.setString(1, username);
	        Ps.setString(2, password);
	        
	        rs = Ps.executeQuery();
	        status = rs.next(); // Returns true if a record exists

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if(rs != null) 
	        	rs.close();
//	        if(Ps != null)
//	        	Ps.close();
//	        if(con != null)
	        	//con.close();
	    }
	    return status;
	}

}
