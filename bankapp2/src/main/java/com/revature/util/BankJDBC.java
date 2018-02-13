package com.revature.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;

import com.revature.beans.User;

public class BankJDBC {
	
	private Logger log = Logger.getRootLogger();
	
	public int save(User u) {
		
		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@orcl.c5yldq6qf75t.us-east-2.rds.amazonaws.com:1521:orcl",
				"bank", "pass")){
			log.trace("connection established");
			PreparedStatement ps = con.prepareStatement("INSERT INTO bank_user (username, pass, balance) VALUES (?,?, 0)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			
			int s = ps.executeUpdate();
			log.debug(s + " rows inserted");
			
		} catch (SQLException e) {
			log.warn("failed");
		}
		return 0;
	}
	
	public User getUser(String u, String p) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@orcl.c5yldq6qf75t.us-east-2.rds.amazonaws.com:1521:orcl",
				"bank", "pass")){
			log.trace("connection established");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM bank_user "
					+ "WHERE username = ? AND pass = ?");
			ps.setString(1, u);
			ps.setString(2, p);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				User user = new User(rs.getString("username"),rs.getString("pass"),rs.getDouble("balance"));
				log.trace("username " + user.getUsername() + "balance " + user.getBalance());
				return user;
			} else {
				log.trace("user not found");
			}
			
		} catch (SQLException e) {
			log.warn("failed");
		}
	
		return null;
	}
	
	public void update(User u, double amount) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@orcl.c5yldq6qf75t.us-east-2.rds.amazonaws.com:1521:orcl",
				"bank", "pass")){
			log.trace("connection established");
			PreparedStatement ps = con.prepareStatement("UPDATE bank_user SET balance = balance + ? WHERE username = ?");
			ps.setDouble(1, amount);
			ps.setString(2, u.getUsername());
			
			int s = ps.executeUpdate();
			log.debug(s + " rows updated");
			
		} catch (SQLException e) {
			log.warn("failed");
		}
	
	}
	public void getTransactions(String username) {		
		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@orcl.c5yldq6qf75t.us-east-2.rds.amazonaws.com:1521:orcl",
				"bank", "pass")){
			log.trace("connection established");
			PreparedStatement ps = con.prepareStatement("SELECT get_transactions(?) FROM DUAL");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			rs.next();
			rs = (ResultSet) rs.getObject(1);
			while (rs.next()){
				String a = rs.getString(1);
				Date b = rs.getDate(2);
				System.out.println(a + " " + b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed");
		}
	}
}

