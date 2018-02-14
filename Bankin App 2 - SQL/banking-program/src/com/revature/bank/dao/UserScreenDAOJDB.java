package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.bank.bean.User;
import com.revature.bank.util.ConnectionUtil;

public class UserScreenDAOJDB implements UserScreenDAO {

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public double viewBalance(String username) {
		User us = new User();
		double balance = us.getBalance();
		log.trace("method called to view balance ");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT balance FROM users  WHERE username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				balance = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed ");
		}
		return balance;
	}

	@Override
	public void deposit(String username, double amountD) {

		UserScreenDAO us = new UserScreenDAOJDB();
		double balance = us.viewBalance(username) + amountD;
		log.trace("method called to view balance ");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(("UPDATE users SET balance = ? WHERE Username = ?"));

			ps.setDouble(1, balance);
			ps.setString(2, username);

			ps.executeUpdate();

			log.trace("amount Deposited");
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed to deposit");
		}

	}

	@Override
	public void withdaw(String username, double amountW) {

		UserScreenDAO us = new UserScreenDAOJDB();
		double balance = us.viewBalance(username) - amountW;
		log.trace("method called to view balance ");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(("UPDATE users SET balance = ? WHERE Username = ?"));

			ps.setDouble(1, balance);
			ps.setString(2, username);

			ps.executeUpdate();

			log.trace("amount Withdrawn ");
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed to deposit");
		}
	}
}
