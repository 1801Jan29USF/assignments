package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BankConnectionUtil {
	private Properties prop = new Properties();
	private static BankConnectionUtil connUtil = new BankConnectionUtil();
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private BankConnectionUtil() {
		super();
		try {
			prop.load(new FileReader("src/main/resources/database.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("pass"));
	}

	public static BankConnectionUtil getConnectionUtil() {
		return connUtil;
	}
}