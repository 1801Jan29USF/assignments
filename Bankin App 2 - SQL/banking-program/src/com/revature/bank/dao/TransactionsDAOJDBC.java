package com.revature.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.bank.bean.User;
import com.revature.bank.bean.UserTranactions;
import com.revature.bank.util.ConnectionUtil;

public class TransactionsDAOJDBC implements TransactionsDAO{
	
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	
	

	

	@Override
	public void addTransaction(User username, UserTranactions trans) {
		//User user = new User(username);
		try (Connection conn = connUtil.getConnection()) {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO Transactions (UserId, amntDeposit, amntWithdraw,Transaction_date) VALUES (?,?,?,?)");
		ps.setInt(1, username.getUserid());
		ps.setDouble(2, trans.getAmntDeposit());
		ps.setDouble(3, trans.getAmntWithdra());
		ps.setTimestamp(4,trans.getCurrentTime());

		ps.executeUpdate();

	} catch (SQLException e) {
		log.warn("Failed to insert transaction.");
	}
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserTranactions> getTransactions(int id) {
		
		
		try (Connection conn = connUtil.getConnection()) {
			List<UserTranactions> list = new ArrayList<UserTranactions>();
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM users INNER JOIN Transactions USING(userid) WHERE userid = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserTranactions trans = new UserTranactions(rs.getInt("TransactionId"), rs.getInt("UserId"),
						rs.getDouble("amntDeposit"), rs.getDouble("amntWithdraw"),
						rs.getTimestamp("Transaction_date"));
				list.add(trans);
			}
			return list;
		} catch (SQLException e) {
			log.warn("Failed to query transactions.");
		}
		
		return null;
	}
	
	
	
	

}
