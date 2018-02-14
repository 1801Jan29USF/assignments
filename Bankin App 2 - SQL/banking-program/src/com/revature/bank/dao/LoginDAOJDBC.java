package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bank.bean.User;
import com.revature.bank.util.ConnectionUtil;

public class LoginDAOJDBC implements  LoginDAO {
	
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		LoginDAO user = new LoginDAOJDBC();

		User us = new User();
		
		System.out.println("Please enter a username");
		String username = scan.nextLine();
		System.out.println("Please enter a password");
		String password = scan.nextLine();
		
		user.login(username, password);
		System.out.println("Login was successful " + user.login(username, password) );
		
		
	}


	@Override
	public User login(String username, String password) {
//		 log.trace("method called to insert new flashcard");
//	        log.trace("Attempting to get connection to db");
	        try (Connection conn = connUtil.getConnection()) {
	          //  log.trace("connection established with db, creating prepared statement");
	            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE Username = ? AND Pasword = ?");	
	          //  log.trace("prepard statement is good");
	            ps.setString(1, username);
	            ps.setString(2, password);
	          //  log.trace("ps is good");
	            ResultSet rs = ps.executeQuery();
			    if(rs.next()){
			    	User user = new User( rs.getString("Username"), rs.getString("Pasword"), rs.getDouble("balance"));
					return user;			    	
		        }
	           
	        } catch (SQLException e) {
	            log.warn("failed to login");
	            e.printStackTrace();
	        }
	        return this.login(username, password) ;
	}

}
