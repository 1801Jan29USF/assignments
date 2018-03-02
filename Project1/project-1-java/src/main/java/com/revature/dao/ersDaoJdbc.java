package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.ReimbRequest;
import com.revature.beans.Reimbursement;
import com.revature.beans.ResolutionRequest;
import com.revature.beans.User;
import com.revature.beans.newUser;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.internal.OracleTypes;

public class ersDaoJdbc implements ersDao {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	public boolean createUser(newUser user) {
		log.trace("method called to create user " + user.getUsername());
		try (Connection conn = connUtil.getConnection()) {
			CallableStatement cs = conn.prepareCall("call new_user(?,?,?,?,?,?)");
			cs.setString(1, user.getUsername());
			cs.setString(2, user.getPassword());
			cs.setString(3, user.getFirstname());
			cs.setString(4, user.getLastname());
			cs.setString(5, user.getEmail());
			cs.setString(6, "Employee");
			cs.execute();
			return true;
		} catch (SQLException e) {
			log.debug("failed to add user");
			e.printStackTrace();
			return false;
		}
		
	}

	public User retrieveUser(String username, String password) {
		log.trace("Attempting to retrieve user data");
		try (Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT user_first_name, "
					+ "user_last_name, user_email, user_role "
					+ "FROM ers_users INNER JOIN user_roles ON ers_users.user_role_id = user_roles.ers_user_role_id "
					+ "WHERE ers_username = ? AND ers_password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				User us = new User(username, password, 
					rs.getString("user_first_name"), rs.getString("user_last_name"),
					rs.getString("user_email"), rs.getString("user_role"));
				return us;
			}
			return null;
			
		} catch (SQLException e) {
			log.debug("failed to add user");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean logReimbursementRequest(ReimbRequest r) {
		log.trace("method called to log a reimbursement request for" + r.getUsername());
		try (Connection conn = connUtil.getConnection()) {
			CallableStatement cs = conn.prepareCall("call new_reimb(?,?,?,?,?)");
			cs.setDouble(1, r.getAmount());
			cs.setString(2, r.getDescription());
			cs.setString(3, r.getType());
			cs.setString(4, r.getUsername());
			cs.setString(5, r.getPassword());
			cs.execute();
			return true;
		} catch (SQLException e) {
			log.debug("failed to add reimbursement");
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Reimbursement> getReimbursements(User user) {
		log.trace("method called to find all reimbursements visible by current user");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			List<Reimbursement> re = new ArrayList<>();
			CallableStatement cs = conn.prepareCall("{ call get_reimbursement_data(?, ?, ?) }");
			
			cs.setString(1, user.getUsername());
			cs.setString(2, user.getPassword());
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(3);
			while (rs.next()) {
				Reimbursement rb = new Reimbursement(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"), rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"), rs.getString("reimb_description"), rs.getString("ers_username"),
						"", rs.getString("reimb_status"), rs.getString("reimb_type"));
				System.out.println(rb.getSubmitted().getTime());
				re.add(rb);
			}
			log.trace("retreived all reimbursements and returning the list");
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed to retreive reimbursements");
		}
		return null;		
	}

	public boolean setResolved(ResolutionRequest rq) {
		log.trace("method called to resolve a reimbursement");
		log.trace("Attempting to get connection to db");
		try (Connection conn = connUtil.getConnection()) {
			CallableStatement cs = conn.prepareCall("{ call resolve_reimb(?, ?, ?, ?, ?) }");
			cs.setString(1, rq.getUsername());
			cs.setString(2, rq.getPassword());
			cs.setDouble(3, rq.getId());
			cs.setString(4, rq.getNewStatus());
			cs.registerOutParameter(5, OracleTypes.CHAR);
			cs.execute();
			String x = cs.getString(5);
			log.trace("result of " + x);
			return (x.equals("t"));
		} catch (SQLException e) {
			e.printStackTrace();
			log.warn("failed to retreive reimbursements");
			return false;
		}
	}
}
