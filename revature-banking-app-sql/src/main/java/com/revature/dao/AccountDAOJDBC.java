package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.util.ConnectionUtil;

/*
 * Implementation of the Account DAO containing methods for
 * creating and deleting Accounts
 */


public class AccountDAOJDBC implements AccountDAO {
	
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public void createAccount(int id, String name, String type) {
		log.trace("method called to create new account for user with id: " + id);
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save account");
			CallableStatement cs = conn.prepareCall("call create_account_for_user(?,?,?,?)");
			cs.setInt(1, id);
			cs.setString(2, name);
			cs.setString(3, type);
			cs.setInt(4, 0);
			cs.execute();
		} catch (SQLException e) {
			log.warn("failed to create new account for user with id: " + id);
			System.out.println("The account name that you have chosen already exists. Please select a different name and try again");
		}

	}

	@Override
	public void deleteAccount(int id, String acctName) {
		log.trace("method called to delete an account");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save account");
			PreparedStatement ps = conn.prepareStatement("DELETE FROM accounts WHERE account_name = ?");
			ps.setString(1, acctName);
			ps.executeUpdate();
			ps = conn.prepareStatement("INSERT INTO transactions (user_id, trans) VALUES (?,?)");
			ps.setInt(1, id);
			String t = "Deletion of " + acctName + " account created by user with id: " + id;
			ps.setString(2, t);
			ps.executeUpdate();
		} catch (SQLException e) {
			log.warn("failed to insert new account");

		}
	}
}
