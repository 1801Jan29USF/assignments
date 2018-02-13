package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Transaction;
import com.revature.beans.User;
import com.revature.util.BankConnectionUtil;

public class BankDAOJDBC implements BankDAO {
	private Logger log = Logger.getRootLogger();
	private BankConnectionUtil connUtil = BankConnectionUtil.getConnectionUtil();

	@Override
	public void addUser(User u) {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO bank_user(username, password, balance) VALUES (?,?,?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setDouble(3, u.getBalance());
			ps.executeUpdate();

		} catch (SQLException e) {
			log.warn("Failed to insert new user.");
		}
	}

	@Override
	public void addUserWithUsername(User u, String userName) {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO bank_user (username, password, balance) VALUES (?,?,?)");
			ps.setString(1, userName);
			ps.setString(2, u.getPassword());
			ps.setDouble(3, u.getBalance());
			ps.execute();

		} catch (SQLException e) {
			log.warn("Failed to insert new user with username " + userName);
		}
	}

	@Override
	public void update(User u) {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE bank_user SET username = ?, password = ?, balance = ? " + "WHERE user_id = ?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setDouble(3, u.getBalance());
			ps.setInt(4, u.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			log.warn("Failed to update user.");
		}
	}

	@Override
	public User getUser(String userName) {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_user WHERE username = ?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User u = User.getUser(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"),
						rs.getDouble("balance"));
				return u;
			} else {
				log.trace("No user found with username " + userName);
				System.exit(0);
			}

		} catch (SQLException e) {
			log.warn("Failed to query user.");
		}
		return null;
	}

	@Override
	public void withdraw(User u, double amount) {
		try (Connection conn = connUtil.getConnection()) {
			CallableStatement cs = conn.prepareCall("{call withdraw(?,?)}");
			cs.setInt(1, u.getId());
			cs.setDouble(2, amount);
			cs.executeUpdate();

		} catch (SQLException e) {
			log.warn("Failed to withdraw. Amount not withdrawn from database.");
		}
	}

	@Override
	public void deposit(User u, double amount) {
		try (Connection conn = connUtil.getConnection()) {
			CallableStatement cs = conn.prepareCall("{call deposit(?,?)}");
			cs.setInt(1, u.getId());
			cs.setDouble(2, amount);
			cs.executeUpdate();

		} catch (SQLException e) {
			log.warn("Failed to deposit. Amount not desposited into database.");
		}
	}

	@Override
	public void addTransaction(User u, Transaction t) {
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO bank_transaction (user_id, amount_deposited, amount_withdrawn, "
							+ "transaction_date) VALUES (?,?,?,?)");
			ps.setInt(1, u.getId());
			ps.setDouble(2, t.getDeposited());
			ps.setDouble(3, t.getWithdrawn());
			ps.setTimestamp(4, t.getDate());

			ps.executeUpdate();

		} catch (SQLException e) {
			log.warn("Failed to insert transaction.");
		}
	}

	@Override
	public List<Transaction> getTransactions(int id) {
		try (Connection conn = connUtil.getConnection()) {
			List<Transaction> list = new ArrayList<Transaction>();
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM bank_user INNER JOIN bank_transaction USING(user_id) WHERE user_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction t = new Transaction(rs.getInt("transaction_id"), rs.getInt("user_id"),
						rs.getDouble("amount_deposited"), rs.getDouble("amount_withdrawn"),
						rs.getTimestamp("transaction_date"));
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			log.warn("Failed to query transactions.");
		}
		return null;
	}
}