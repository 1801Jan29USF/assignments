package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.bean.Users;
import com.revature.util.ConnectionUtil;

public class BankDAOJDBC implements BankDAO {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	
//	public static void main(String[] args) {
//	BankDAO bankDao = new BankDAOJDBC();
//
//
//	}
	
	
	@Override
	public int insert(Users user) {
		// TODO Auto-generated method stub
		log.trace("method called to insert new user");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()){
			log.trace("connection established with db");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users (user_name, user_password) VALUES (?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				user.setUserId(rs.getInt(1));
				return rs.getInt(1);
			}

			} catch (SQLException e) {
				e.printStackTrace();
				log.warn("failed to register");
			}

				return 0;

		
	}	
		

	@Override
	public Users signup(String username, String password) {
		log.trace("method called to signup for the account");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()){
			log.trace("connection established with db");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO users (user_name, user_password) VALUES (?,?)" );
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			
			int statement = ps.executeUpdate();
			log.debug("User with Username " + username + " sucessfully registred");
			
//			ResultSet rs = ps.executeQuery();
//			if (rs.next() == false) {
//				Users user = new Users (username, password,0);
//				insert(user);
//				return user;
//				}

	} catch (SQLException e) {
		e.printStackTrace();
		
	}
	return null;

	}
	
	

	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
			
		log.trace("method called to login");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()){
			log.trace("connection established with db");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE user_name = ?");
			
			ps.setString(1, username);
			int statement = ps.executeUpdate();
			
//			ResultSet rs = ps.executeQuery();
////			int resultCheck = ps.executeUpdate();
//			if (rs.next()) {
////			if (resultCheck == 1 ) {
//				Users user = new Users (rs.getString("user_name"), rs.getString("user_password"), rs.getInt("user_Id"));
//				return user;
//			}
//			else {
//				log.trace("user name with " + username + " not found");
//			}

			} catch (SQLException e) {
				e.printStackTrace();
				log.warn("failed to login");
			}

				return null;
		
	}
			
	@Override
	public void deposit(int amount, String accountname, int account_id) {
		// TODO Auto-generated method stub
		
		log.trace("method called to deposit to the account");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()){
			log.trace("connection established with db");
			PreparedStatement ps = conn.prepareStatement("UPDATE transactions SET deposit_amount = ? WHERE Account_id = ?");
			ps.setInt(1, amount);
			ps.setInt(2, account_id);		
			ps.executeUpdate();
			log.debug("transacitons updated");
			PreparedStatement ps2 = conn.prepareStatement("UPDATE Accounts SET account_balance = account_balance + ? WHERE account_name = ?");
			ps2.setInt(1,  amount);
			ps2.setString(2, accountname);
			ps2.executeUpdate();
			log.debug("balace updated");
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				Users user = new Users (rs.getString("username"), rs.getString("password"), rs.getInt("userId"), 0, null);
//				return user;
//			}
//			else {
//				log.trace("user name with " + username + " not found");
//			}
			
		
//			
			
			} catch (SQLException e) {
				e.printStackTrace();
				log.warn("failed to deposit");
			}

				return;		
	}
	

	@Override
	public int viewBalance(int userId, String username) {
		// TODO Auto-generated method stub
		
			int balance = 0;	
			log.trace("method called to view balance");
			log.trace("Attempting to get connection to db");
			
			try (Connection conn = connUtil.getConnection()){
				log.trace("connection established with db");
				PreparedStatement ps = conn.prepareStatement("SELECT account_balance from accounts WHERE account_name =  ? ");
				
				ps.setString(1, username);
				int statement = ps.executeUpdate();
				log.debug("Balance for the account name " + username + " is " + balance);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					rs.getInt("balance");
				}
			

				} catch (SQLException e) {
					e.printStackTrace();
					
				}

					return balance;
			
		}
		

	@Override
	public void withdraw(String username, int withdrawAmount) {
		// TODO Auto-generated method stub
		log.trace("method called to withdraw from the account");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()){
			log.trace("connection established with db");
			PreparedStatement ps = conn.prepareStatement("UPDATE transactions SET withdraw_amount = ?  WHERE user_name = ?"); 
			ps.setInt(1, withdrawAmount);
			ps.setString(2, username);
			ps.executeUpdate();
			
			
			PreparedStatement ps2 = conn.prepareStatement("UPDATE account SET baance = balance -  ?  WHERE user_name = ?"); 
			ps2.setInt(1, withdrawAmount);
			ps2.setString(2, username);
			ps2.executeUpdate();
			
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				Users user = new Users (rs.getString("username"), rs.getString("password"), rs.getInt("userId"), 0, null);
//				return user;
//			}
//			else {
//				log.trace("user name with " + username + " not found");
//			}
			
			
//			PreparedStatement ps2 = conn.prepareStatement("INSERT INTO transactions (userId, trans) VALUES (?,?)");
//			ps2.setInt(1, userId);
//			String t = depositAmount + "has been Withdraw";
//			ps2.setString(2,t);
//			ps2.executeUpdate();
//			
			
			} catch (SQLException e) {
				e.printStackTrace();
				log.warn("failed to withdraw");
			}

				return;		
	}
		

	
	
	
	@Override
	public void displayTransaction(int userID) {
		// TODO Auto-generated method stub
		log.trace("method called to display balance");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()){
			log.trace("connection established with db");
			PreparedStatement ps = conn.prepareStatement(" ");
			
			ResultSet rs = ps.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
				log.warn("failed to display transactions");
			}

				
		
	}
	
	

	}
