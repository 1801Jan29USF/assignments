package com.revature.bank.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionUtil {
	
	private Properties prop = new Properties();
	private static ConnectionUtil connutil = new ConnectionUtil();
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private ConnectionUtil() {
		super();
		try {
			prop.load((new FileReader("src/main/resources/database.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"), prop.getProperty("pass"));
	}
	
	public static ConnectionUtil getConnectionUtil() {
		return connutil;
	}

}
