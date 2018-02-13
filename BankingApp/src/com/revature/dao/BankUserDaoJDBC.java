package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Transaction;
import com.revature.exceptions.InvalidPasswordException;
import com.revature.exceptions.OverdraftException;
import com.revature.util.ConnectionUtil;

public class BankUserDaoJDBC implements BankUserDao {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	

	@Override
	public void withdraw(String username, String password, Double amount) throws SQLException, OverdraftException, InvalidPasswordException {
		log.trace("method called to withdraw from user account");
        log.trace("Attempting to get connection to db");
        if(!correctPassword(username, password)) {
        	throw new InvalidPasswordException();
        }
        try (Connection conn = connUtil.getConnection()) {
        	CallableStatement cs = conn.prepareCall("{? = call withdraw(?, ?)}");
        	String overdraft;
        	cs.registerOutParameter(1, Types.CHAR);
        	cs.setString(2, username);
        	cs.setDouble(3, amount);
        	cs.execute();
        	overdraft = cs.getString(1);
        	if (overdraft.equals("t")) {
        		log.debug("The user attempted to withdraw more than they had");
        		 throw new OverdraftException();
        	 }
        }

	}

	@Override
	public void deposit(String username, Double amount) throws SQLException {
		log.trace("method called to deposit from user account");
        log.trace("Attempting to get connection to db");
        try (Connection conn = connUtil.getConnection()) {
        	CallableStatement cs = conn.prepareCall("{CALL deposit(?, ?)}");
        	 cs.setString(1, username);
        	 cs.setDouble(2, amount);
        	 cs.execute();
        }
	}

	@Override
	public List<Transaction> getTransactionHistory(String username) throws SQLException {
		log.trace("method called to retrieve user balance");
        log.trace("Attempting to get connection to db");
        List<Transaction> resultTransactions = new ArrayList<Transaction>();
        try (Connection conn = connUtil.getConnection()) {
        	 PreparedStatement ps = conn.prepareStatement("SELECT amount, transaction_timestamp FROM transactions " + 
        	 		"WHERE username = ?");
        	 ps.setString(1, username);
        	 ResultSet rs = ps.executeQuery();
        	 log.trace("Parsing results...");
        	 while (rs.next()) {
        		 Double amount = rs.getDouble("amount");
        		 Transaction temp = new Transaction(amount, rs.getTimestamp("transaction_timestamp"), username);
        		 resultTransactions.add(temp);
        	 }

        }
        return resultTransactions;
	}
	@Override
	public Double getBalance(String username) throws SQLException {
		log.trace("method called to retrieve user balance");
        log.trace("Attempting to get connection to db");
        try (Connection conn = connUtil.getConnection()) {
        	 PreparedStatement ps = conn.prepareStatement("SELECT balance FROM bank_user WHERE username = ?");
        	 ps.setString(1, username);
        	 ResultSet rs = ps.executeQuery();
        	 if (rs.next()) {
        		 log.trace("Balance found. Retrieving...");
        		 Double d = rs.getDouble("balance");
        		 return d;
        	 }
        }
		return -1.00;
	}
	
	public void makeUser(String username, String password) throws SQLException {
		log.trace("method called to insert new BankUser");
        log.trace("Attempting to get connection to db");
        try (Connection conn = connUtil.getConnection()) {
        	CallableStatement cs = conn.prepareCall("{CALL add_user(?, ?)}");
        	cs.setString(1, username);
        	cs.setString(2, password);
        	cs.execute();
	}

}
	public boolean userExists(String username) throws SQLException {
		log.trace("method called to verify whether or not a user already exists");
        log.trace("Attempting to get connection to db");
        boolean exists = false;
        try (Connection conn = connUtil.getConnection()) {
        	PreparedStatement ps = conn.prepareStatement("SELECT username FROM bank_user WHERE username = ?");
        	ps.setString(1, username);
        	ResultSet rs = ps.executeQuery();
        	if(rs.next()) {
        		exists = true;
        	}
        }
        return exists;
	}
	
	public boolean correctPassword(String username, String password) throws SQLException {
		log.trace("method called to verify that the password matches a given username");
        log.trace("Attempting to get connection to db");
        try (Connection conn = connUtil.getConnection()) {
        	CallableStatement cs = conn.prepareCall("{? = call login(?, ?)}");
        	String correctpw;
        	cs.registerOutParameter(1, Types.CHAR);
        	cs.setString(2, username);
        	cs.setString(3, password);
        	cs.execute();
        	correctpw = cs.getString(1);
        	if (correctpw.equals("t")) {
        		log.trace("The user correctly entered their password");
        		return true;
        	 }
        	log.debug("The user entered the incorrect password");
        	return false;
        }

	}
}
