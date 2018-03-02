package com.revature.dao;

import java.util.List;

import com.revature.beans.ReimbRequest;
import com.revature.beans.Reimbursement;
import com.revature.beans.ResolutionRequest;
import com.revature.beans.User;
import com.revature.beans.newUser;

public interface ersDao {
	
	public boolean createUser(newUser nu);
	
	public User retrieveUser(String username, String password);
	
	public boolean logReimbursementRequest(ReimbRequest r);
	
	public List<Reimbursement> getReimbursements(User user);
	
	public boolean setResolved(ResolutionRequest rq);

}
