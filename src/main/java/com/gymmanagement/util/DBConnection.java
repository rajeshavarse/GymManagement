package com.gymmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
public static Connection getConnection() {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gymmanagement", "root", "vsoft123");
		return con;
	}catch(Exception e) {
		System.out.println(e);
	}
	return null;
}

}
