package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.bankapp.Bank;
import com.revature.bankapp.BankUser;
import com.revature.util.ConnectionUtil;

/**
 * THe Data Access Object for the BankUser bean.
 * 
 * @author Rick
 *
 */
public class BankUserDAO {

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	Bank b = Bank.getSingleton();
	private int r;

	public void save(BankUser bu) {

		log.trace("Method called to insert new bank user.");
		log.trace("Attempting to get connection to db.");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("Connection established with db, creating prepared statement.");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO bankusers(username,pw,balance) VALUES(?,?,?)");
			ps.setString(1, bu.getUsername());
			ps.setString(2, bu.getPassword());
			ps.setDouble(3, bu.getBalance());
			int rowsInserted = ps.executeUpdate();
			log.debug("This query inserted: " + rowsInserted + "row in the db.");
		} catch (SQLException e) {
			log.warn("Failed to insert user.");
			e.printStackTrace();
		}

	}

	public void update(BankUser bu) {

		log.trace("Method called to update an existing user's info");
		log.trace("Attempting to get connection to db.");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("Connection established with db, creating prepared statement.");
			PreparedStatement ps = conn.prepareStatement("UPDATE bankusers SET balance = ? WHERE buserid = ?");
			ps.setDouble(1, bu.getBalance());
			ps.setInt(2, r);
			int rowsInserted = ps.executeUpdate();
			log.debug("This query updated: " + rowsInserted + " row in the db.");
		} catch (SQLException e) {
			log.warn("Failed to update bank user.");
			e.printStackTrace();
		}
	}

	public void delete(BankUser bu) {
		log.trace("Method called to delete an existing user's info");
		log.trace("Attempting to get connection to db.");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("Connection established with db, creating prepared statement.");
			PreparedStatement ps = conn.prepareStatement("DELETE bankusers WHERE username = ?");
			ps.setString(1, bu.getUsername());
			int rowsInserted = ps.executeUpdate();
			log.debug("This query deleted: " + rowsInserted + " row in the db.");
		} catch (SQLException e) {
			log.warn("Failed to update bank user.");
			e.printStackTrace();
		}
	}

	public int getid(String username) {
		log.trace("Method called to select id for user: " + username + ".");
		log.trace("Attempting to get connection to db.");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("Connection established with db, creating prepared statement.");
			PreparedStatement ps = conn.prepareStatement("SELECT buserid FROM bankusers WHERE username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r = rs.getInt("buserid");
				return r;
			}
		} catch (SQLException e) {
			log.trace("No bank user found.");
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<BankUser> getUserList() {
		ArrayList<BankUser> bL = new ArrayList<BankUser>();
		log.trace("Method called to get the existing users.");
		log.trace("Attempting to get connection to db.");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("Connection established with db, creating prepared statement.");
			PreparedStatement ps = conn.prepareStatement("SELECT username, pw, balance FROM bankusers ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BankUser bu = new BankUser(rs.getString("username"), rs.getString("pw"), rs.getDouble("balance"));
				bL.add(bu);
			}
		} catch (SQLException e) {
			log.warn("It seems that there are no users.");
			e.printStackTrace();
		}
		// log.trace("Here are the existing users" + bL);
		return bL;
	}

}
