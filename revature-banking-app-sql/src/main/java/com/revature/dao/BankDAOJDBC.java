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
			PreparedStatement ps = conn.prepareStatement("INSERT INTO bank_users (username, pass) VALUES (?,?)",
					new String[] { "user_id" });
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());

			int rowsInserted = ps.executeUpdate();
			log.debug("query inserted " + rowsInserted + " rows into the bank_users");
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
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_users WHERE username = ?");
			ps.setString(1, u);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("pass"));
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
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_users WHERE username = ?");
			ps.setString(1, u);
			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				User user = new User(0, u, p);
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
	public void deposit(int id, int amt, String acctName) {
		log.trace("method called to deposit money into account");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE account_name = ?");
			ps.setInt(1, amt);
			ps.setString(2, acctName);
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement("INSERT INTO transactions (user_id, trans) VALUES (?,?)");
			ps2.setInt(1, id);
			String t = "Deposited " + amt + "$ into " + acctName;
			ps2.setString(2, t);
			ps2.executeUpdate();

		} catch (SQLException e) {
			log.warn("failed to retrieve user");
		}
	}

	@Override
	public void withdraw(int id, int amt, String acctName) {
		log.trace("method called to withdraw money from account");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE account_name = ?");
			ps.setInt(1, amt);
			ps.setString(2, acctName);
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement("INSERT INTO transactions (user_id, trans) VALUES (?,?)");
			ps2.setInt(1, id);
			String t = "Withdrew " + amt + "$ into " + acctName;
			ps2.setString(2, t);
			ps2.executeUpdate();

		} catch (SQLException e) {
			log.warn("failed to retrieve user");
		}
	}

	@Override
	public int balance(int id, String acctName) {
		log.trace("method called to view account balance");
		log.trace("Attempting to get connection to db");
		int balance = 0;
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn.prepareStatement("SELECT balance FROM accounts WHERE account_name = ?");
			ps.setString(1, acctName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				balance = rs.getInt("balance");
			}
		} catch (SQLException e) {
			log.warn("failed to retrieve user");
		}
		return balance;

	}

	@Override
	public void transfer(int id, int amt, String acctFrom, String acctTo) {
		log.trace("method called to transfer money");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE account_name = ?");
			ps.setInt(1, amt);
			ps.setString(2, acctFrom);
			ps.executeUpdate();
			PreparedStatement ps2 = conn
					.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE account_name = ?");
			ps2.setInt(1, amt);
			ps2.setString(2, acctTo);
			ps2.executeUpdate();
			PreparedStatement ps3 = conn.prepareStatement("INSERT INTO transactions (user_id, trans) VALUES (?,?)");
			ps3.setInt(1, id);
			String t = "Transferred " + amt + "$ from " + acctFrom + "to " + acctTo;
			ps3.setString(2, t);
			ps3.executeUpdate();

		}

		catch (SQLException e) {
			log.warn("failed to retrieve user");
		}

	}

	@Override
	public void quickPay(String acct, String receiver, int id, int amount) {
		log.trace("method called to transfer money");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");

			PreparedStatement ps = conn
					.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE account_name = ?");
			ps.setInt(1, amount);
			ps.setString(2, acct);
			ps.executeUpdate();
			ps = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE account_name = ?");
			ps.setInt(1, amount);
			ps.setString(2, receiver);
			ps.executeUpdate();

			PreparedStatement ps2 = conn.prepareStatement("INSERT INTO transactions (user_id, trans) VALUES (?,?)");
			ps2.setInt(1, id);
			String t = "Quickpayed " + amount + "$ to " + receiver;
			ps2.setString(2, t);
			ps2.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean updateUserPass(int id, String u, String p) {
		boolean added = true;
		log.trace("method called to transfer update username and password");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");

			PreparedStatement ps = conn.prepareStatement("SELECT *FROM bank_users WHERE username = ?");
			ps.setString(1, u);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				added = false;

			} else {
				PreparedStatement ps2 = conn
						.prepareStatement("UPDATE bank_users SET username = ? , pass = ? WHERE user_id = " + id);
				ps2.setString(1, u);
				ps2.setString(2, p);
				ps2.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added;
	}

	@Override
	public void printTrans(int id) {
		log.trace("method called to print user transactions");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save user");

			PreparedStatement ps = conn.prepareStatement("SELECT *FROM transactions WHERE user_id = " + id);
			ResultSet rs = ps.executeQuery();
			System.out.println("Your Transaction History:\n");
			while (rs.next()) {
				System.out.println(rs.getString("trans") + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUserProfile(int id) {
		log.trace("method called to delete user");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement to save account");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO transactions (user_id, trans) VALUES (?,?)");
			ps.setInt(1, id);
			String t = "Deletion of user profile with id: " + id;
			ps.setString(2, t);
			ps.executeUpdate();
			PreparedStatement ps2 = conn.prepareStatement("DELETE FROM bank_users WHERE user_id = ?");
			ps2.setInt(1, id);
			ps2.executeUpdate();
			return;
		} catch (SQLException e) {
			log.warn("failed to delete profile");
		}

	}

}
