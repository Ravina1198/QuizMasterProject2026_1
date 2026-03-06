package com.main;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import com.test.entity.InsertData;
import com.test.entity.Student;
import com.test.entity.StudentLogin;
import com.validation.test.Validationservice;

import co.quiz.questions.QuizService;


public class Executionmain {
	
  public static void main(String[] args) throws ClassNotFoundException, ExecutionException {
	         Scanner scanner = new Scanner(System.in);
	         Validationservice valService = new Validationservice();
	         StudentLogin studentlogin =new StudentLogin();
	         boolean isLoggedIn=false;
	         String currentStudent = "";
	        
	        

	         while (true) {
	             System.out.println("\nUser Operation");
	             System.out.println("1. Student Registration");
	             System.out.println("2. Student Login");
	             System.out.print("Select Option: ");
	             
	             int choice = scanner.nextInt();
	             
	             switch(choice) {
	          
	             case 1:
	            	 Student student = new Student(); 
	            	 // Collecting Data
	                 System.out.print("Enter First Name: "); student.setFirstName(scanner.next());
	                 System.out.print("Enter Last Name: "); student.setLastName(scanner.next());
	                 System.out.print("Enter Username: "); student.setUsername(scanner.next());
	                 System.out.print("Enter Password: "); student.setPassword(scanner.next());
	                 System.out.print("Enter City: "); student.setCity(scanner.next());
	                 System.out.print("Enter Email ID: "); student.setEmail(scanner.next());
	                 System.out.print("Enter Mobile Number: "); student.setMobileNumber(scanner.next());

	                 // STEP 1: Validation using your Validationservice class
	                 boolean isEmailValid = valService.isValidGmail(student.getEmail());
	                 boolean isMobileValid = valService.isValidMobileManual(student.getMobileNumber());
	                 boolean isPassValid = valService.isValidPassword(student.getPassword());

	                 if (isEmailValid && isMobileValid && isPassValid) {
	                     
	                     // STEP 2: Connecting to DB_connection to store the data
	                     try {
	                         boolean isSaved = InsertData.getUserinput(student);
	                         if (isSaved) {
	                             System.out.println("✅ Registration Successful and stored in Database!");
	                         }
	                     } catch (SQLException e) {
	                         System.out.println("❌ Database Error: " + e.getMessage());
	                     }

	                 } else {
	                     System.out.println("❌ Validation Failed! Please check your inputs.");
	                 }
	                 break;//exit loop
	             case 2:
	            	  isLoggedIn= false;
	            	 System.out.print("Enter Username: ");
	                    String user = scanner.next();
	                    System.out.print("Enter Password: ");
	                    String pass = scanner.next();

	                    try {
	                        // We ask the DB_connection class to check the table
	                       isLoggedIn = studentlogin.loginStudent(user, pass);

	                        if (isLoggedIn) {
	                          
	                            System.out.println("✅ Login Success! Welcome " + currentStudent);
	                        } else {
	                            System.out.println("❌ Invalid Credentials. Try again.");
	                        }
	                    } catch (SQLException e) {
	                        System.err.println("Database Error: " + e.getMessage());
	                    }
	                    break;

	                case 3:
	                    // JVM checks the 'isLoggedIn' flag here
	                	 
	                    if (isLoggedIn) {
	                        System.out.println("=== Starting Java Quiz ===");
	                        QuizService quizService = new QuizService();
							// Call your Quiz Logic Method here
	                        quizService.startQuizProcess(currentStudent);
	                    } else {
	                        System.out.println("⚠️ Access Denied! You must Login (Option 2) first.");
	                    }
	                    break;

	             }
	             

	             
	                 
	                 
	                 
                           
	                    
	             // Add other cases (Login, Quiz, etc.) here...
	         }
	     }
	 
		       

	}


	
