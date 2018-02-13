package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	
	private Properties prop = new Properties(); 
	 private static ConnectionUtil connUtil = new ConnectionUtil();
	
	private ConnectionUtil() {
		super();
		// TODO Auto-generated constructor stub
		try {
		prop.load(new FileReader ("src/main/recources/database.properties"));
	} catch (IOException e ) {
		e.printStackTrace();
	}}

	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), 
				prop.getProperty("pass"));
	}
	

    public static ConnectionUtil getConnectionUtil() {
        return connUtil;
    }

}

