package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bank.bean.User;
import com.revature.bank.screens.MainMenu;
import com.revature.bank.util.ConnectionUtil;

public class AddUserDAOJDBC implements AddUserDAO {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		AddUserDAO user = new AddUserDAOJDBC();

		User us = new User();

		System.out.println("------New user registration------");
		System.out.println("Please enter a username");
		String username = scan.nextLine();
		System.out.println("Please enter a password");
		String password = scan.nextLine();
		
		System.out.println("Please enter intital amaount to add to account");
		double balance = Double.parseDouble(scan.nextLine());

		user.addUser(username, password,balance);
		System.out.println("query inserted " + us.getUserName() + us.getPassword() + " rows into the db");

	}

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public int addUser(String username, String password, Double balance) {
		User s = new User(username, password, balance);

//		log.trace("Method called to add new user");
//		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			//log.trace("connection established with db, creating prepared statement");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users ( Username, Pasword, balance) VALUES (?,?,?)",new String[] { "userid" });
			//log.trace("prepstatment good");
			//ps.setLong(1, s.getUserid());
			ps.setString(1, s.getUserName());		
			ps.setString(2, s.getPassword());
			ps.setDouble(3, s.getBalance());
			  int rowsInserted = ps.executeUpdate();
	            log.debug("query inserted " + rowsInserted + " rows into the db");
			 ResultSet rs = ps.getGeneratedKeys();
			  if (rs.next()) {
		        	s.setUserid(rs.getInt(1));
		        	return rs.getInt(1);
		        }  

		} catch (SQLException e) {
			log.warn("failed to insert new user");
			  e.printStackTrace();
		}
		return 0 ;

	}

	@Override
	public User checkIfUser(String username) {
//		log.trace("Method called to add new user");
//		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			//log.trace("connection established with db, creating prepared statement");
			PreparedStatement ps = conn.prepareStatement("SELECT username FROM users WHERE username = ?");
			//log.trace("Checking Username");
			//ps.setLong(1, s.getUserid());
			ps.setString(1, username);			

			 ResultSet rs = ps.executeQuery();
			  if (rs.next()) {
				  User user = new User(rs.getString("username"));
				 
				  return user;
		        }  
			  
		} catch (SQLException e) {
			log.warn("failed check user user");
			  e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public User checkIfPassword(String pasword) {
		
//		log.trace("Method called to add new user");
//		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			//log.trace("connection established with db, creating prepared statement");
			PreparedStatement ps = conn.prepareStatement("SELECT Pasword FROM users WHERE Pasword = ?");
			//log.trace("Checking Username");
			//ps.setLong(1, s.getUserid());
			ps.setString(1, pasword);			

			 ResultSet rs = ps.executeQuery();
			  if (rs.next()) {
				  User user = new User(rs.getString("Pasword"));
				 
				  return user;
		        }  
			  
		} catch (SQLException e) {
			log.warn("failed to check password");
			  e.printStackTrace();
		}
		
		
		return null;

	}

}
