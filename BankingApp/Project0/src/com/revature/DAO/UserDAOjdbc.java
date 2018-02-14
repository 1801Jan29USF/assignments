package com.revature.DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.User;
import com.revature.util.ConnectionUtility;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class UserDAOjdbc implements BankDAO {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtility connUtil = ConnectionUtility.getConnectionUtil();
	
	/**
	 * Take in a user object. Connect to the database then insert into the table.
	 * Returns the generated ID. Inputs "1" as a generic id for all inserts
	 * because it requires it as a parameter. There is a trigger in the database 
	 * that automatically generates the actual id. All balances start at 0f.
	 * Returns -1 if it fails.
	 */
	@Override
	public int register(User u) {
		log.trace("Method called to add new user.");
		log.trace("Attempting to connect to database.");
		try(Connection conn = connUtil.getConnection()) { 
			log.trace("Connection successful.");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO user_table(username, user_pass, balance) VALUES(?, ?, ?)",
					new String[] {"USER_ID"});
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setFloat(3, 0f);
			
			int rowsInserted = ps.executeUpdate();
			log.debug("Query inserted " + rowsInserted + " row(s) into the db");
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				u.setUser_id(rs.getInt(1));
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("Failed to insert new user.");
		}
		return -1;
	}

	/**
	 * Takes in a username as an input. Connects to the database and searches for that username
	 * If it exists, report back true. If not, false.
	 * Used during the login and register screens.
	 */
	@Override
	public boolean exists(String username) {
		log.trace("Method called to check if user exists.");
		log.trace("Attempting to connect to database.");
		try(Connection conn = connUtil.getConnection()) { 
			log.trace("Connection successful.");
			PreparedStatement ps = conn.prepareStatement("SELECT username FROM user_table WHERE username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				// If there's anything in the result set it will be the username
				return true;
			} else {
				// Select still returns a result set if it doesn't find anything, its just empty
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("SQL error. Method 'exists' returns false by default.");
		}
		return false;
	}

	/**
	 * Takes in a user object. Connects to the database and sets the balance of the user
	 * that matches the given id to the given balance. Dao assumes that the balance adjustments
	 * were made before reaching this point. 
	 * Since this method can fail, return true/false to
	 * let the calling method know if it should revert its changes.
	 */
	@Override
	public boolean updateBalance(User u) {
		log.trace("Method called to update user.");
		log.trace("Attempting to connect to database.");
		try(Connection conn = connUtil.getConnection()) { 
			log.trace("Connection successful.");
			PreparedStatement ps = conn.prepareStatement("UPDATE user_table SET balance = ? WHERE user_id = ?");
			ps.setFloat(1, u.getBalance());
			ps.setInt(2, u.getUser_id());
			int numRowsUpdated = ps.executeUpdate();
			log.trace("Updated " + numRowsUpdated + " row(s).");
			return true;
		} catch (SQLException e) {
			log.warn("SQL error. Failed to update user balance.");
			return false;
		}
		
	}

	/**
	 * Takes in user object. Looks for record on database that matches the given id.
	 * Forms a temp user object from the result set then returns the tmpUser balance.
	 * I did it this way because I didn't fully understand the generatedkeys example.
	 * I kinda did, but this way was a sure bet.
	 */
	@Override
	public float viewBalance(User u) {
		log.trace("Method called to view balance.");
		log.trace("Attempting to connect to database.");
		try(Connection conn = connUtil.getConnection()) {
			log.trace("Connection successful.");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_table WHERE user_id = ?");
			ps.setInt(1, u.getUser_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User tmpUser = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("user_pass"), rs.getFloat("balance"));
				return tmpUser.getBalance();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("SQL error. Failed to retreive balance.");
		}
		return -1f;
	}

	/**
	 * Nothing fancy. Returns a boolean so that the caller knows if it succeeded or not.
	 */
	@Override
	public boolean delete(User u) {
		log.trace("Method called to delete the user.");
		log.trace("Attempting to connect to the database.");
		try(Connection conn = connUtil.getConnection()) {
			log.trace("Connection successful.");
			PreparedStatement ps = conn.prepareStatement("DELETE FROM user_table WHERE user_id = ?");
			ps.setInt(1, u.getUser_id());
			int numRowsDeleted = ps.executeUpdate();
			log.debug("Query inserted " + numRowsDeleted + " row(s) deleted.");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("SQL error. Failed to delete user.");
			return false;
		}
	}

	/**
	 * Used to retrieve a user's information. Returns a user object if successful.
	 * Returns NULL if not. 
	 */
	@Override
	public User getUser(String username) {
		log.trace("Method called to get User with username " + username);
		log.trace("Attempting to connect to database.");
		try(Connection conn = connUtil.getConnection()) {
			log.trace("Connection successful.");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user_table WHERE username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User newUser = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("user_pass"), rs.getFloat("balance"));
				return newUser;
			} else {
				log.warn("No user found with name " + username);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("SQL error. Failed to retrieve user.");
		}
		return null;
	}

	@Override
	public List<String> getHistory(User u) {
		List<String> resultString = new ArrayList<>();
		log.trace("Method called to get user history with username " + u.getUsername());
		log.trace("Attempting to connect to database.");
		try(Connection conn = connUtil.getConnection()) {
			log.trace("Connection successful.");
			CallableStatement cs = conn.prepareCall("{call get_user_history(?, ?)}");
			cs.setString(1, u.getUsername());
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rset = ((OracleCallableStatement)cs).getCursor(2);
			log.trace("Check");
			while(rset.next()) {
				log.trace("Attempting to store result set.");
				resultString.add("audit id: " + rset.getInt("audit_id") +
						" old user id: " + rset.getInt("old_user_id") +
						" new user id: " + rset.getInt("new_user_id") +
						" old username: " + rset.getString("old_username") +
						" new username: " + rset.getString("new_username") +
						" old password: " + rset.getString("old_password") +
						" new password: " + rset.getString("new_password") +
						" old balance: " + rset.getString("old_balance") +
						" new balance: " + rset.getString("new_balance") +
						" audit time: " + rset.getDate("audit_time")
						);
			}
			log.trace("Finished going through result set.");
			return resultString;
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("SQL error. Failed to retrieve user history.");
		}
		return null;	
	}
}











