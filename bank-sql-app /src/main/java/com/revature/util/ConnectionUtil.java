package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

		
//		private Properties prop = new Properties(); 
		 private static ConnectionUtil connUtil = new ConnectionUtil();
		
		private ConnectionUtil() {
			super();
			// TODO Auto-generated constructor stub
//			try {
//			prop.load(new FileReader ("src/main/resources/database.properties"));
//		} catch (IOException e ) {
//			e.printStackTrace();
//		}
		}

		public Connection getConnection() throws SQLException{
			return DriverManager.getConnection("jdbc:oracle:thin:@orcl.cw45psqshtej.us-east-2.rds.amazonaws.com:1521:ORCL", "banks", 
					"p4ssw0rd");
		}
		

	    public static ConnectionUtil getConnectionUtil() {
	        return connUtil;
	    }

	}
