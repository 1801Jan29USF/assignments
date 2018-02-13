package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.UserToAccount;
import com.revature.interfaces.JunctionDAO;
import com.revature.util.singleton.jdbc.ConnectionUtil;

/**
 * DAO for user_to_account in banking application
 * 
 * @author Bobby McGetrick
 *
 */
public class UserToAccountDAO implements JunctionDAO<UserToAccount> {
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new UserToAccountDAO
	 */
	public UserToAccountDAO() {
		super();
		log.trace("Constructing new UserToAccountDAO");
		log.trace("Called super constructor - Object");
		log.trace("New UserToAccountDAO created");
	}

	/************************************************************************************
	 * Create
	 ************************************************************************************/
	/**
	 * Try to establish a connection to the Bank database using ConnectionUtil
	 * If connection is successful then build and send an Oracle SQL query to 
	 * insert a new UserToAccount to the accounts table
	 * 
	 * @param UserToAccount newUserToAccount
	 */
	@Override
	public int create(UserToAccount newUserToAccount) {
		log.trace("Method called to insert a new UserToAccount: " + newUserToAccount);
		log.trace("Attempting to get connection to Bank database");
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.trace("Connection established with database, creating prepared statement");
			PreparedStatement prepedStatement = conn.prepareStatement("INSERT INTO user_to_account "
					+ "(user_id, account_id) VALUES (?,?)");
			
			log.trace("Retrieve user id from the new UserToAccount and inserting it into the SQL query");
			prepedStatement.setInt(1, newUserToAccount.getUserId());
			log.trace("Retrieve account id from the new UserToAccount and inserting it into the SQL query");
			prepedStatement.setInt(2, newUserToAccount.getAccountId());
			
			log.trace("Executing SQL query and retrieving the number of new rows inserted"
					+ "into Bank database's user table");
			int numRowsInserted = prepedStatement.executeUpdate();
			log.debug("SQL query inserted " + numRowsInserted + " rows into the Bank database's user table");
			
			log.trace("Retrieving the result set of the SQL query");

		} catch (SQLException e) {
			log.warn("Failed to insert new UserToAccount - SQLException caught, printing stack trace");
			e.printStackTrace();
		}
		log.trace("Returning 0");
		return 0;
	}

	/************************************************************************************
	 * Retrieve
	 ************************************************************************************/
	/**
	 * Returns null
	 * user_to_account table has a composite key of 2 foreign keys
	 * See getByUserId() and getByAccountId() to retrieve a UserToAccount
	 * 
	 * @param int nothing
	 */
	@Override
	public UserToAccount get(int nothing) {
		return null;
	}
	
	/**
	 * Returns null
	 * UserToAccount does not contain a String field
	 * 
	 * @param String nothing
	 */
	@Override
	public UserToAccount get(String nothing) {
		return null;
	}
	
	/**
	 * Try to establish a connection to the Bank database using ConnectionUtil
	 * If connection is successful then build and send an Oracle SQL query to 
	 * retrieve a UserToAccount from the user_to_account table using the user id and account id
	 * 
	 * @param int id
	 */	
	@Override
	public UserToAccount getByCompositeKey(int userId, int accountId) {
		log.trace("Method called to select a UserToAccount with user id: " + userId + " and account id: " + accountId);
		log.trace("Attempting to get connection to Bank database");
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.trace("Connection established with database, creating prepared statement");
			PreparedStatement prepedStatement = conn.prepareStatement("SELECT * FROM user_to_account "
					+ "WHERE user_id = ? AND account_id = ?");
			
			log.trace("Insertinting accountId " + accountId + " into the SQL query");
			prepedStatement.setInt(1, userId);
			prepedStatement.setInt(2, accountId);
			
			log.trace("Executing SQL query and retrieving its resul set");
			ResultSet resultSet = prepedStatement.executeQuery();
			
			log.trace("Checking if result set has an entry");
			if (resultSet.next()) {
				log.trace("Creating a new UserToAccount with data from the result set");
				UserToAccount newUserToAccount = new UserToAccount(resultSet.getInt("user_id"), resultSet.getInt("account_id"));
				log.trace("Returning UserToAccount with user id: " + userId + " and account accountId: " + accountId);
				return newUserToAccount;
			}
		} catch (SQLException e) {
			log.warn("Failed to retrieve account - SQLException caught, printing stack trace");
			e.printStackTrace();
		}
		log.trace("Returning null");
		return null;
	}

	/************************************************************************************
	 * Update
	 ************************************************************************************/
	/**
	 * Try to establish a connection to the Bank database using ConnectionUtil
	 * If connection is successful then build and send an Oracle SQL query to 
	 * update an UserToAccount in the accounts table
	 * 
	 * @param UserToAccount UserToAccount
	 */
	@Override
	public void update(UserToAccount newUserToAccount) {
		log.trace("Method called to update an UserToAccount: " + newUserToAccount);
		log.trace("Attempting to get connection to Bank database");	
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.trace("Connection established with database, creating prepared statement");
			PreparedStatement prepedStatement = conn.prepareStatement("UPDATE user_to_account "
					+ "SET user_id = " + newUserToAccount.getUserId()
					+ ", account_id = " + newUserToAccount.getAccountId()
					+ "WHERE user_id = " + newUserToAccount.getUserId()
					+ ", account_id = " + newUserToAccount.getAccountId());
			
			log.trace("Executing SQL query and retrieving the number of new rows updated"
					+ "into Bank database's accounts table");
			int numRowsUpdated = prepedStatement.executeUpdate();
			log.debug("SQL query updated " + numRowsUpdated + " rows in the Bank database's user_to_account table");
		} catch (SQLException e) {
			log.warn("Failed to update account - SQLException caught, printing stack trace");
			e.printStackTrace();
		}		
	}

	/**
	 * Try to establish a connection to the Bank database using ConnectionUtil
	 * If connection is successful then build and send an Oracle SQL query to 
	 * delete an UserToAccount to the user_to_account table
	 * 
	 * @param UserToAccount newUserToAccount
	 */
	@Override
	public void delete(UserToAccount newUserToAccount) {
		log.trace("Method called to delete a UserToAccount: " + newUserToAccount);
		log.trace("Attempting to get connection to Bank database");
		try (Connection conn = ConnectionUtil.getConnection()) {
			log.trace("Connection established with database, creating prepared statement");
			PreparedStatement prepedStatement = conn.prepareStatement("DELETE FROM user_to_account "
					+ "WHERE user_id = " + newUserToAccount.getUserId()
					+ "account_id = " + newUserToAccount.getAccountId());
			
			log.trace("Executing SQL query and retrieving the number of new rows deleted"
					+ "into Bank database's user_to_account table");
			int numRowsDeleted = prepedStatement.executeUpdate();
			log.debug("SQL query inerted " + numRowsDeleted + " rows from the Bank database's user_to_account table");
		} catch (SQLException e) {
			log.warn("Failed to delete account - SQLException caught, printing stack trace");
			e.printStackTrace();
		}
	}

}
