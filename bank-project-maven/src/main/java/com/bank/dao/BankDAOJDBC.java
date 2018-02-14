package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.bank.beans.AuthUser;
import com.bank.beans.Transaction;
import com.bank.screens.MainMenu;

public class BankDAOJDBC implements bankDAO {

	private Logger log = Logger.getRootLogger();

	private static bankDAO bdao = new BankDAOJDBC();

	private int currentUserID;

	public int getCurrentUserID() {
		return currentUserID;
	}

	public void setCurrentUserID(int currentUserID) {
		this.currentUserID = currentUserID;
	}

	@Override
	public int addUser(AuthUser m) {

		log.trace("method called to add new user");

		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@orcl.cyppvjcqzrjr.us-east-2.rds.amazonaws.com:1521:ORCL", "banking", "p4ssw0rd")) {

			PreparedStatement ps = conn.prepareStatement("DECLARE BEGIN add_user(USER_ID_SEQ.NEXTVAL, ?, ?, ?); END;");
			ps.setString(1, m.getUsername());
			ps.setString(2, m.getPassword());
			ps.setDouble(3, m.getBalance());

			int rowsInserted = ps.executeUpdate();
			log.debug("query inserted " + rowsInserted + " rows into the db");

		} catch (SQLException e) {
			log.warn("Failed - This username may already be taken!");
		}
		return 0;

	}

	@Override
	public void deposit(int userid, double amount) {
		log.trace("method called to deposit");

		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@orcl.cyppvjcqzrjr.us-east-2.rds.amazonaws.com:1521:ORCL", "banking", "p4ssw0rd")) {

			PreparedStatement ps = conn.prepareStatement("DECLARE BEGIN deposit_balance(?, ?); END;");
			ps.setInt(1, userid);
			ps.setDouble(2, amount);

			int rowsUpdated = ps.executeUpdate();
			log.debug("deposit inserted, " + rowsUpdated + " rows updated.");

		} catch (SQLException e) {
			log.warn("Unable to complete deposit.");
		}

	}

	@Override
	public void withdraw(int userid, double amount) {
		// TODO Auto-generated method stub log.trace("method called to deposit");
		log.trace("Method called to withdraw");

		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@orcl.cyppvjcqzrjr.us-east-2.rds.amazonaws.com:1521:ORCL", "banking", "p4ssw0rd")) {

			PreparedStatement ps = conn.prepareStatement("DECLARE BEGIN withdraw_balance(?, ?); END;");
			ps.setInt(1, userid);
			ps.setDouble(2, amount);

			int rowsUpdated = ps.executeUpdate();
			log.debug("withdraw complete, " + rowsUpdated + " rows updated.");

		} catch (SQLException e) {
			log.warn("Unable to complete withdrawal, withdrawing amount exceeds balance!");
		}

	}

	@Override
	public double getUserBal(int id) {
		log.trace("method called to get user balance");

		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@orcl.cyppvjcqzrjr.us-east-2.rds.amazonaws.com:1521:ORCL", "banking", "p4ssw0rd")) {

			PreparedStatement ps = conn.prepareStatement("SELECT balance FROM users where user_id = ?");

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				double current = rs.getDouble(1);
				return current;
			}

			log.debug("balance request complete:");

		} catch (SQLException e) {
			log.warn("Unable to obtain balance.");
		}
		return 0;
	}

	public static bankDAO getBdao() {
		return bdao;
	}

	@Override
	public void login(String inputname, String inputpass) {
		log.trace("attempting to log in");

		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@orcl.cyppvjcqzrjr.us-east-2.rds.amazonaws.com:1521:ORCL", "banking", "p4ssw0rd")) {
			log.trace("Connection established!");

			PreparedStatement ps = conn.prepareStatement("SELECT USER_ID FROM USERS WHERE username = ? AND pass = ?");

			ps.setString(1, inputname);

			ps.setString(2, inputpass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				currentUserID = rs.getInt(1);
			} else {
				log.warn("No user found.");
			}

		} catch (SQLException e) {
			log.warn("Unable to login.");
		}

	}

	@Override
	public void getUserHistory(int id) {
		log.trace("Fetching transaction history...");
		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@orcl.cyppvjcqzrjr.us-east-2.rds.amazonaws.com:1521:ORCL", "banking", "p4ssw0rd")) {
			PreparedStatement ps = conn.prepareStatement("SELECT * from TRANSACTIONS"
					+ " INNER JOIN USERS on Transactions.u_id=USERS.user_id where u_id = ? ORDER BY LOG_TIME ASC");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Transaction t = new Transaction(rs.getInt("transact_id"), rs.getInt("u_id"),
						rs.getDouble("Before_Balance"), rs.getDouble("After_Balance"), rs.getString("Log_time"));
				System.out.println((t.toString()));
			}

		} catch (SQLException e) {
			log.warn("unable to obtain history.");
			e.printStackTrace();
		}

	}
}
