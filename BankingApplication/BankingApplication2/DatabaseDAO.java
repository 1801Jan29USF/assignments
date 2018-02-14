package com.revature.BankingApplication;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.apache.log4j.Logger;
import com.revature.BankingApplication.connectionUtil;



public class DatabaseDAO implements BankingDAO {
	private Logger log = Logger.getRootLogger();
	private connectionUtil connUtil = connectionUtil.getConnectionUtil();
	
	

	@Override
	public int Register(UserStorage us) {
		// TODO Auto-generated method stub
		log.trace("New user trying to register");
		log.trace("Attempting to get connection to IBM database");
   try(Connection conn = connUtil.getConnection()) {
	   //preparedstatement helps against SQL injection 
	   log.trace("connection established with IBM server, creating new user account");
	   PreparedStatement ps = conn.prepareStatement("INSERT INTO BANK_USER (User_id, Username, Password, Balance) VALUES (Bank_user_id_seq.nextVal,?,?,?)");
       ps.setString(1, us.getUsername());
	   ps.setString(2, us.getPassword());
	   ps.setDouble(3, us.getBalance());
	   
	   //insert the registered user into the database 
	   int rowsInserted = ps.executeUpdate();
	   log.debug("new user " + rowsInserted + " has been registered to the server");
	   
} catch (SQLIntegrityConstraintViolationException e) {
	log.warn("Sorry! failed to register new user. Username is already taken.");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return 0;

	}
	//Update user's balance by getting the balance and username from UserStorage
	public void Update(UserStorage us) {
		try (Connection conn = connUtil.getConnection()) {	
			PreparedStatement s = conn.prepareStatement("UPDATE BANK_USER SET balance =? WHERE username=?");
		    s.setDouble(1, us.getBalance());
		    s.setString(2, us.getUsername());
			s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed to get user profile");
		}
		
	}
	//Login getting the username, password, and balance from the database
	@Override
	public UserStorage get(String username, String password) {
		// TODO Auto-generated method stub
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement s = conn.prepareStatement("SELECT username, password, balance FROM bank_user WHERE username=? AND password=?");
			s.setString(1, username);
			s.setString(2, password);
			ResultSet rs = s.executeQuery();
			if (rs.next()) {
			  UserStorage User = new UserStorage(rs.getString("username"), rs.getString("password"), rs.getDouble("balance"));
			  return User;
			} else {

			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//get transaction history from user by using the username
	public void getTransaction(String username) {
		try(Connection conn = connUtil.getConnection()) {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_transaction WHERE username =?");
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("Balance = " + rs.getDouble("balance") + " Time = " + rs.getTimestamp("Time") );
		}
	} catch(SQLException e) {
		e.printStackTrace();
		log.warn("No transactions have been made");
	}

	}
}