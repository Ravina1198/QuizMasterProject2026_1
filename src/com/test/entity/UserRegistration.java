package com.test.entity;

public interface UserRegistration {

	void registerStudent(Student student);
	boolean validateLogin (String username, String password);
	void isUsernameExists(String username);

}
