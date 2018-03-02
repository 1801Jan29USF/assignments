package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.ReimbursementStatus;
import com.revature.interfaces.DAO;
import com.revature.util.ConnectionUtil;

public class StatusDAO implements DAO<ReimbursementStatus> {

	@Override
	public int create(ReimbursementStatus stat) {
		return 0;
	}

	@Override
	public ReimbursementStatus get(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM"
					+ " ers_reimbursement_status WHERE reimb_status_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ReimbursementStatus status = new ReimbursementStatus(
						rs.getInt("reimb_status_id")
						, rs.getString("reimb_status")
						);
				return status;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ReimbursementStatus get(ReimbursementStatus stat) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM"
					+ " ers_reimbursement_status WHERE reimb_status = ?");
			ps.setString(1, stat.getStatus());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ReimbursementStatus status = new ReimbursementStatus(
						rs.getInt("reimb_status_id")
						, rs.getString("reimb_status")
						);
				return status;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(ReimbursementStatus arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ReimbursementStatus arg0) {
		// TODO Auto-generated method stub
		
	}

}
