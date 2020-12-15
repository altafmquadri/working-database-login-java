package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private Connection conn = null;
	public static final String URL = "jdbc:h2:~/test";
	
	public DBConnection() {
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(URL,"sa","");
			System.out.println("Database connection successful");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return conn;
	}

}
