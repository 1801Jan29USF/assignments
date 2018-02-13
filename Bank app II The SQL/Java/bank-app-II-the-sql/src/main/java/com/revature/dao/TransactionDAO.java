package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Transaction;
import com.revature.interfaces.MultiResultDAO;
import com.revature.util.singleton.jdbc.ConnectionUtil;


/**
 * DAO for transactions in banking application
 * 
 * @author Bobby McGetrick
 *
 */
public class TransactionDAO implements MultiResultDAO<Transaction> {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private int accountId;
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new TransactionDAO
	 */
	public TransactionDAO() {
		super();
		log.trace("Constructing new TransactionDAO");
		log.trace("Called super constructor - Object");
		log.trace("New TransactionDAO created");
	}
	
//	/**
//	 * Create new TransactionDAO with predefined values
//	 * 
//	 * @param int userId
//	 * @param int accountId
//	 */
//	public TransactionDAO(int userId, int accountId) {
//		super();
//		log.trace("Constructing new TransactionDAO");
//		log.trace("Called super constructor - Object");
//		log.trace("Setting user id to " + userId);
//		this.accountId = userId;
//		log.trace("Setting account id to " + accountId);
//		this.accountId = accountId;
//		log.trace("New TransactionDAO created");
//	}
	
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate TransactionDAO hash code
	 */
	@Override
	public int hashCode() {
		log.trace("Genrating Transaction hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + accountId;
		log.trace("Returning Transaction hash code");
		return result;
	}

	/**
	 * Check if Transaction is equivalent to another Object
	 * @param Object obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.trace("Checking if Transaction is equivalent to the passed Object " + obj );
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionDAO other = (TransactionDAO) obj;
		if (accountId != other.accountId)
			return false;
		if (accountId != other.accountId)
			return false;
		return true;
	}
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve Transcation.userId
	 * @return int userId
	 */
	public int getUserId() {
		return accountId;
	}

	/**
	 * Setting Transcation.userId to a given integer
	 * @return int usertId
	 */
	public void setUserId(int userId) {
		this.accountId = userId;
	}

	/**
	 * Retrieve Transcation.accountId
	 * @return int accountId
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * Setting Transcation.accountId to a given integer
	 * @return int accountId
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/************************************************************************************
	 * Create
	 ************************************************************************************/
	/**
	 * Try to establish a connection to the Bank database using ConnectionUtil
	 * If connection is successful then build and send an Oracle SQL query to 
	 * insert a new Transaction to the transactions table
	 * 
	 * @param Transaction newTransaction
	 */
	@Override
	public int create(Transaction newTransaction) {
		log.trace("Method called to insert a new Transaction: " + newTransaction);
		log.trace("Attempting to get connection to  Bank database");
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.trace("Connection established with database, creating prepared statement");
			PreparedStatement prepedStatement = conn.prepareStatement("INSERT INTO transactions "
					+ "(user_id, account_id, amount_deposited, transaction_date) VALUES (?,?,?,?)",
					new String[] { "transaction_id" });
			
			log.trace("Retrieve user id, account id, amount eposited, date from the new "
					+ "transaction and inserting it into the SQL query");
			prepedStatement.setInt(1, newTransaction.getUserId());
			prepedStatement.setInt(2, newTransaction.getAccountId());
			prepedStatement.setFloat(3, newTransaction.getAmountDeposited());
			prepedStatement.setTimestamp(4, Timestamp.valueOf(newTransaction.getDate()));
			
			log.trace("Executing SQL query and retrieving the number of new rows inserted"
					+ "into Bank database's transactions table");
			int numRowsInserted = 0;
			numRowsInserted = prepedStatement.executeUpdate();
			log.debug("SQL query inserted " + numRowsInserted + " rows into the Bank database's transactions table");
			
			log.trace("Retrieving the result set of the SQL query");
			ResultSet resultSet = prepedStatement.getGeneratedKeys();
			
			log.trace("Checking if result set has an entry");
			if (resultSet.next()) {
				log.trace("Setting the new transaction's transaction ID to the transaction ID generated by the Bank database");
				newTransaction.setId(resultSet.getInt(1));
				log.trace("Returning the user ID generated by the Bank database");
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			log.warn("Failed to insert new transaction - SQLException caught, printing stack trace");
			e.printStackTrace();
		}
		log.trace("Returning 0");
		return 0;  
	}

	/************************************************************************************
	 * Retrieve
	 ************************************************************************************/
	/**
	 * Try to establish a connection to the Bank database using ConnectionUtil If
	 * connection is successful then build and send an Oracle SQL query to retrieve
	 * a Transaction from the transactions table using the transaction id
	 * 
	 * @param int id
	 */
	@Override
	public Transaction get(int id) {
		log.trace("Method called to select a Transaction with id: " + id);
		log.trace("Attempting to get connection to Bank database");
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.trace("Connection established with database, creating prepared statement");
			PreparedStatement prepedStatement = conn.prepareStatement("SELECT * FROM transactions " + "WHERE transaction_id = ?");

			log.trace("Insertinting transactionId " + id + " into the SQL query");
			prepedStatement.setInt(1, id);

			log.trace("Executing SQL query and retrieving its result set");
			ResultSet resultSet = prepedStatement.executeQuery();

			log.trace("Checking if result set has an entry");
			if (resultSet.next()) {
				log.trace("Creating a new Transaction with data from the result set");
				Transaction newTransaction = new Transaction(resultSet.getInt("transaction_id"), resultSet.getInt("user_id"),
						resultSet.getInt("account_id"), resultSet.getFloat("ammount_deposited"), resultSet.getTimestamp("transaction_date").toLocalDateTime());
				log.trace("Returning Transaction wth transaction id: " + id);
				return newTransaction;
			}
		} catch (SQLException e) {
			log.warn("Failed to retrieve transaction - SQLException caught, printing stack trace");
			e.printStackTrace();
		}
		log.trace("Returning null");
		return null;
	}

	/**
	 * Transaction has not Strings associated with it
	 * Can't search by String
	 * 
	 * @param String nothing
	 * 
	 * @return null
	 */
	@Override
	public Transaction get(String nothing) {
		return null;
	}
	
	/**
	 * Try to establish a connection to the Bank database using ConnectionUtil
	 * If connection is successful then build and send an Oracle SQL query to 
	 * retrieve all Transactions that belong to a given user id
	 * 
	 * @param int userId
	 * 
	 * @return List<Transaction>
	 */
	@Override
	public List<Transaction> getAllByUserId(int userId) {
		log.trace("Method called to select all Transactions related to user id: " + userId);
		log.trace("Attempting to get connection to Bank database");
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.trace("Connection established with database, creating prepa`red statement");
			PreparedStatement prepedStatement = conn.prepareStatement("SELECT transaction_id, user_id, trans.account_id, amount_deposited, transaction_date "
					+ "FROM accounts accnts "
					+ "INNER JOIN transactions trans ON (accnts.account_id = trans.account_id) "
					+ "WHERE user_id = ?");
			
			log.trace("Insertinting accountId " + userId + " into the SQL query");
			prepedStatement.setInt(1, userId);
			
			log.trace("Executing SQL query and retrieving its resul set");
			ResultSet resultSet = prepedStatement.executeQuery();
			
			log.trace("Creating a List of Transactions");
			List<Transaction> transactionList = new ArrayList<Transaction>();
			
			log.trace("Checking if result set has an entry");
			while (resultSet.next()) {
				log.trace("Creating a new Transaction with data from the result set");
				Transaction newTransaction = new Transaction(resultSet.getInt("transaction_id"), resultSet.getInt("user_id")
						, resultSet.getInt("account_id"), resultSet.getFloat("amount_deposited"), resultSet.getTimestamp("transaction_date").toLocalDateTime());
				transactionList.add(newTransaction);
			}
			
			log.trace("Returning List of transactions transactionList");
			return transactionList;
			
		} catch (SQLException e) {
			log.warn("Failed to retrieve transactions - SQLException caught, printing stack trace");
			e.printStackTrace();
		}
		log.trace("Returning null");
		return null;
	}
	
	@Override
	public List<Transaction> getAllByAccountId(int accountId) {
		log.trace("Method called to select all Transactions related to user id: " + accountId);
		log.trace("Attempting to get connection to Bank database");
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.trace("Connection established with database, creating prepa`red statement");
			PreparedStatement prepedStatement = conn.prepareStatement("SELECT transaction_id, user_id, trans.account_id"
					+ ", amount_deposited, transaction_date FROM accounts accnts "
					+ "INNER JOIN transactions trans ON (accnts.account_id = trans.account_id) "
					+ "WHERE user_id = 1 AND accnts.account_id = ?");
			
			log.trace("Insertinting accountId " + accountId + " into the SQL query");
			prepedStatement.setInt(1, accountId);
			
			log.trace("Executing SQL query and retrieving its resul set");
			ResultSet resultSet = prepedStatement.executeQuery();
			
			log.trace("Creating a List of Transactions");
			List<Transaction> transactionList = new ArrayList<Transaction>();
			
			log.trace("Checking if result set has an entry");
			while (resultSet.next()) {
				log.trace("Creating a new Transaction with data from the result set");
				Transaction newTransaction = new Transaction(resultSet.getInt("transaction_id"), resultSet.getInt("user_id")
						, resultSet.getInt("account_id"), resultSet.getFloat("amount_deposited"), resultSet.getTimestamp("transaction_date").toLocalDateTime());
				transactionList.add(newTransaction);
			}
			
			log.trace("Returning List of transactions transactionList");
			return transactionList;
			
		} catch (SQLException e) {
			log.warn("Failed to retrieve transactions - SQLException caught, printing stack trace");
			e.printStackTrace();
		}
		log.trace("Returning null");
		return null;
	}

	/************************************************************************************
	 * Update
	 ************************************************************************************/
	/**
	 * Try to establish a connection to the Bank database using ConnectionUtil If
	 * connection is successful then build and send an Oracle SQL query to update a
	 * Transaction in the transactions table
	 * 
	 * @param int id
	 */
	@Override
	public void update(Transaction transaction) {
		log.trace("Method called to update a Transaction: " + transaction);
		log.trace("Attempting to get connection to Bank database");
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.trace("Connection established with database, creating prepared statement");
			PreparedStatement prepedStatement = conn
					.prepareStatement("UPDATE transactions SET user_id = "+ transaction.getUserId() + ", account_id = " + transaction.getAccountId()
					+ ", amount_deposited = " + transaction.getAmountDeposited() + ", transaction_date = " + transaction.getDate()
					+ " WHERE user_id = " + transaction.getId());

			log.trace("Executing SQL query and retrieving the number of new rows updated"
					+ "into Bank database's transactions table");
			int numRowsUpdated = prepedStatement.executeUpdate();
			log.debug("SQL query updated " + numRowsUpdated + " rows in the Bank database's transactions table");
		} catch (SQLException e) {
			log.warn("Failed to update transaction - SQLException caught, printing stack trace");
			e.printStackTrace();
		}
	}

	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	/**
	 * Try to establish a connection to the Bank database using ConnectionUtil If
	 * connection is successful then build and send an Oracle SQL query to delete a
	 * Transaction from the transactions table
	 * 
	 * @param Transaction transaction
	 * 
	 */
	@Override
	public void delete(Transaction transaction) {
		log.trace("Method called to delete a Transaction: " + transaction);
		log.trace("Attempting to get connection to Bank database");
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.trace("Connection established with database, creating prepared statement");
			PreparedStatement prepedStatement = conn
					.prepareStatement("DELETE FROM transactions " + "WHERE transaction_id = " + transaction.getId());

			log.trace("Executing SQL query and retrieving the number of new rows deleted"
					+ "into Bank database's transactions table");
			int numRowsDeleted = prepedStatement.executeUpdate();
			log.debug("SQL query inerted " + numRowsDeleted + " rows from the Bank database's transactions table");
		} catch (SQLException e) {
			log.warn("Failed to delete transaction - SQLException caught, printing stack trace");
			e.printStackTrace();
		}
	}

}
