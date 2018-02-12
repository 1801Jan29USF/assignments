package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.util.ConnectionUtil;

public class AccountDAOJDBC implements AccountDAO {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public void createAccount(int id, String name, String type) {
		log.trace("method called to create new account");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save account");
			CallableStatement cs = conn.prepareCall("{call create_account_for_user(?,?,?,?)}");
			cs.setInt(1, 0);
			cs.setInt(2, id);
			cs.setString(3, name);
			cs.setString(4, type);
			cs.execute();
		} catch (SQLException e) {
			log.warn("failed to insert new account");
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
			String t = "Deletion of " + acctName + " account created with by user with id: " + id;
			ps.setString(2, t);
			ps.executeUpdate();
			log.trace("account deleted");
		} catch (SQLException e) {
			log.warn("failed to insert new account");
		}

	}

}
