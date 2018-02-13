package com.revature.util.singleton.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * ConnectionUtil Singleton class
 * Abstracts DriverManager away from other code
 * Provides connection to database using information
 * from database.properties
 * @author Bobby McGetrick
 *
 */
public class ConnectionUtil {
	
	/************************************************************************************
	 * Private Fields
	 ************************************************************************************/
	private static Properties prop = new Properties();
	private static ConnectionUtil connUtil = new ConnectionUtil();
	private static Logger log = Logger.getRootLogger();

	/************************************************************************************
	 * Static blocks
	 ************************************************************************************/
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/************************************************************************************
	 * Private constructors
	 ************************************************************************************/
	/**
	 * Create new ConnectionUtil
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
	
	/************************************************************************************
	 * Methods
	 ************************************************************************************/
	/**
	 * Return a ConnectionUtil to setup a ConnecitonUtil Singleton
	 * @return ConnectionUtil
	 */
	public static ConnectionUtil getConnectionUtil() {
		log.trace("Retruning ConnectionUtil ConnectionUtil: " + connUtil);
		return connUtil;
	}
	
	/**
	 * Use DriverManager to establish a connection to our database
	 *  using database information store in database.properties
	 * @return Connection
	 * @throws SQLException
	 */
	static public Connection getConnection() throws SQLException {
		log.trace("Establishing connection to Bank database");
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("pass"));
	}
		
}
