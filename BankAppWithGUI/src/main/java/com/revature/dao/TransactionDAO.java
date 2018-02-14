package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.bankapp.Bank;
import com.revature.util.ConnectionUtil;

/**
 * The Data Access Object that handles transactions.
 * @author Rick
 *
 */
public class TransactionDAO {

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	Bank b = Bank.getSingleton();

	public void savetransaction(Timestamp d, String type, double amount, int buserid) {
		log.trace("Method called to insert a new transaction.");
		log.trace("Attempting to get connection to db.");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("Connection established with db, creating prepared statement.");
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO transactions(dateof,typeoftransaction,amount,buserid) " + "VALUES(?,?,?,?)");
			ps.setTimestamp(1, d);
			ps.setString(2, type);
			ps.setDouble(3, amount);
			ps.setInt(4, buserid);
			int rowsInserted = ps.executeUpdate();
			log.debug("this query inserted: " + rowsInserted + "row in the db.");
		} catch (SQLException e) {
			log.warn("Failed to insert transaction");
			e.printStackTrace();
		}

	}

	public ArrayList<String> getTransactionsList(int i) {
		ArrayList<String> tL = new ArrayList<String>();
		log.trace("Method called to insert a new transaction.");
		log.trace("Attempting to get connection to db.");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("Connection established with db, creating prepared statement.");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM transactions WHERE buserid=?");
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String tran = ("On " + rs.getTimestamp("dateof") + " you made a " + rs.getString("typeoftransaction")
						+ " for the amount of: $" + rs.getDouble("amount") + ".\n");
				tL.add(tran);
			}
		} catch (SQLException e) {
			log.warn("It seems that there are no transactions.");
			e.printStackTrace();
		}
		return tL;
	}
}
