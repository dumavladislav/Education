package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jsbcUrl = "jdbc:mysql://192.168.99.100:32768/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to the DB: " + jsbcUrl);
			Connection myConn = DriverManager.getConnection(jsbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
}
