package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class BankDAOJDBC implements BankDAO {

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public int save(User u) {
		log.trace("method called to insert new user");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO user_account (username, pass, checking, savings) VALUES (?,?,?,?)",
					new String[] { "user_id" });
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.checking);
			ps.setInt(4, u.savings);

			int rowsInserted = ps.executeUpdate();
			log.debug("query inserted " + rowsInserted + " rows into the database");
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				u.setId(rs.getInt(1));
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			log.warn("failed to insert new user");
		}
		return 0;
	}

	@Override
	public User login(String u, String p) {
		log.trace("method called to check for uniqueness of login credentials");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to access");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_account WHERE username = ?");
			ps.setString(1, u);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("pass"),
						rs.getInt("checking"), rs.getInt("savings"));
				return user;
			} else {
				log.trace("No user found with username: " + u + " and password: " + p);
				System.out.println(
						"No user found with username: " + u + " and password: " + p + ". Please check you input.\n");
			}

		} catch (SQLException e) {
			log.warn("failed to retrieve user");
		}
		return null;
	}

	@Override
	public User register(String u, String p) {
		log.trace("method called to check for uniqueness of registration credentials");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_account WHERE username = ?");
			ps.setString(1, u);
			ResultSet rs = ps.executeQuery();
			if (rs.getRow() == 0) {
				User user = new User(0, u, p, 0, 0);
				save(user);
				return user;

			} else {
				log.trace("User credentials are not uniqe.");
			}

		} catch (SQLException e) {
			log.warn("failed to retrieve user");
		}
		return null;
	}

	@Override
	public void deposit(int id, int amt, String type) {
		log.trace("method called to deposit money into account");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE user_account SET " + type + "= " + type + " + " + amt + " WHERE user_id = " + id + ";");
			ps.executeUpdate();

		} catch (SQLException e) {
			log.warn("failed to retrieve user");
		}
	}

	@Override
	public void withdraw(int id, int amt) {
		log.trace("method called to withdraw money from account");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE user_account SET checking = checking - " + amt + " WHERE user_id = " + id + ";");
			ps.executeUpdate();

		} catch (SQLException e) {
			log.warn("failed to retrieve user");
		}
	}

	@Override
	public int balance(int id, String type) {
		log.trace("method called to view account balance");
		log.trace("Attempting to get connection to db");
		int balance = 0;
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn
					.prepareStatement("SELECT " + type + " FROM user_account WHERE user_id = " + id + ";");
			ResultSet rs = ps.executeQuery();
			balance = rs.getInt(type);
		} catch (SQLException e) {
			log.warn("failed to retrieve user");
		}
		return balance;

	}

	@Override
	public void transfer(int id, int amt, String type) {
		log.trace("method called to transfer money");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			if (type.hashCode() == "checking".hashCode()) {
				PreparedStatement ps = conn.prepareStatement(
						"UPDATE user_account SET checking = checking + " + amt + " WHERE user_id = " + id + ";");
				ps.executeUpdate();
				ps = conn.prepareStatement(
						"UPDATE user_account SET checking = checking - " + amt + " WHERE user_id = " + id + ";");
				ps.executeUpdate();
			} else {
				PreparedStatement ps = conn.prepareStatement(
						"UPDATE user_account SET savings = savings + " + amt + " WHERE user_id = " + id + ";");
				ps.executeUpdate();
				ps = conn.prepareStatement(
						"UPDATE user_account SET savings = savings - " + amt + " WHERE user_id = " + id + ";");
				ps.executeUpdate();
			}

		}

		catch (SQLException e) {
			log.warn("failed to retrieve user");
		}

	}

	@Override
	public void quickPay(String receiver, int id, int amount) {
		log.trace("method called to transfer money");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE user_account SET checking = checking - " + amount + " WHERE user_id = " + id + ";");
			ps.executeUpdate();
			ps = conn.prepareStatement(
					"UPDATE user_account SET checking = checking + " + amount + " WHERE username = " + receiver + ";");
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean updateUserPass(int id, String username, String password) {
		boolean added = true;
		log.trace("method called to transfer money");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");

			PreparedStatement ps = conn
					.prepareStatement("SELECT *FROM user_account WHERE username = " + username + ";");
			ResultSet rs = ps.executeQuery();
			if (rs == null) {
				ps = conn.prepareStatement("UPDATE user_account SET username = " + username + "AND password = "
						+ password + " WHERE user_id = " + id + ";");
			} else {
				added = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added;
	}
}
