package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Used to retrieve the URL, username and password. These are necesary for
 * establishing a connection with the database. They are located in the
 * "database.properties" file.
 * 
 * @author Rick
 *
 */
public class ConnectionUtil {

	private Properties prop = new Properties();
	private static ConnectionUtil connUtil = new ConnectionUtil();
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	/*
	 * Reading fro proeprties file.
	 */
	private ConnectionUtil() {
		super();
		try {
			prop.load(new FileReader("src/main/resources/database.properties"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/*
	 * Returning the necessary properties to establish a connection
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}

	public static ConnectionUtil getConnectionUtil() {
		return connUtil;
	}
}
