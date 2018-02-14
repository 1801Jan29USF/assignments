package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.bank.beans.User;
import com.bank.file.io.ConnectionUtil;

public class SFDAOJDBC implements SFDAO {

	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public int save(User u) {
		
		log.trace("method called to insert new User");
		log.trace("Attempting to et connection to db");
		
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with db, creating prepared statement");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO acct_user (user_name, password) VALUES(?,?)", new String[] {"user_id"});
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			
			int rowsInserted = ps.executeUpdate();
			log.debug("a query inserted " + rowsInserted + " row(s) into the db");
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				u.setId(rs.getInt(1));
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println();
            log.warn("failed to insert new user, username not available");
        }
		
		return 0;
	}

	@Override
	public User get(String username, String password) {
		log.trace("method called to get user");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT user_name, password, balance FROM acct_user WHERE user_name=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User u = new User(rs.getString("user_name"), rs.getString("password"), rs.getDouble("balance"));
				return u;
			} else {
				//log.trace("Username or password invalid");
			  }
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive user");
		}
		
		return null;
	}
	
	public void getLog(String username) {
		int id = 0;
		log.trace("method called to get user transactions");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()){
			PreparedStatement ps = conn.prepareStatement("SELECT user_id FROM acct_user WHERE user_name=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getInt("user_id");
			} else {
				//log.trace("Username or password invalid");
			  }
			
			PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM user_transaction WHERE user_id=? ORDER BY time");
			ps2.setInt(1, id);
			rs = ps2.executeQuery();
			while(rs.next()) {
				System.out.println("Amount = " + rs.getDouble("amount") + " Time = " + rs.getTimestamp("time"));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("failed to retreive log");
		}
	}

	@Override
	public void update(User u) {
		
		log.trace("method called to update user");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			Statement s = conn.createStatement();
			int numRowsUpdated = s.executeUpdate("UPDATE acct_user SET balance = " + u.getBalance() + "WHERE user_name= '" + u.getUserName() + "'");
			log.trace("updated " + numRowsUpdated + " rows");
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed to update user");
		}

	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub

	}

}
