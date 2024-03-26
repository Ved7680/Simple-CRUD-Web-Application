package com.royal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// 1. Making Credentials
	private static final String URLNAME = "jdbc:mysql://localhost:3306/veddb";
	private static final String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	// 2. Establishing COnnection
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			
			// 3. Loading Driver class
			Class.forName(DRIVERCLASS);
			
			// 4. Passing Credentials into DriverManagers getConnection Method
			conn = DriverManager.getConnection(URLNAME,USERNAME,PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}                       
		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = DBConnection.getConnection();
		
		// 5. Checking whether the connection is establised or not
		if(conn != null)
		{
			System.out.println("DB Connected -- "+conn);
		}
		else {
			System.out.println("DB Not Connected");
		}
	}
	
}
