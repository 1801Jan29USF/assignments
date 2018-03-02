package com.revature.service;

import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementType;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementTypeDAO;
import com.revature.interfaces.DAO;

/**
* Reimbursement service for the ERS
* Uses ReimbursementDAO to check if the combination of submitted reimbursement credentials
* exits in the ERS database, if so it returns the Reimbursement with matching credentials
* from the ERS database
* 
* @author Bobby McGetrick
*
*/
public class ReimbursementService {
	
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	 private static Logger log = Logger.getRootLogger();
	 
	 /************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new ReimbursementService
	 */
	 public ReimbursementService() {
			super();
	}
	 
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * No non-static fields
	 */
	
	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve Object.log
	 * 
	 * @return Logger log
	 */
	 public static Logger getLog() {
		return log;
	}

	/**
	 * Set Object.log to a given Logger
	 * 
	 * @param Logger log
	 */
	public static void setLog(Logger log) {
		ReimbursementService.log = log;
	}
	
	/************************************************************************************
	 * Methods
	 ************************************************************************************/
	public List<Reimbursement> retrieveUserReimburements(int userId) {
		ReimbursementDAO reimbDAO = new ReimbursementDAO();
		List<Reimbursement> reimbList = new Vector();
		reimbList = reimbDAO.getAll(userId);
		if (reimbList != null) {
			return reimbList;
		}
		return null;
	}
	
	public int getTypeId(String type) {
		ReimbursementType reimbT = new ReimbursementType(type);
		DAO<ReimbursementType> rtDao = new ReimbursementTypeDAO();
		return rtDao.get(reimbT).getId();
	}
	
	public String getType(int typeId) {
		ReimbursementType reimbT = new ReimbursementType(typeId, "");
		DAO<ReimbursementType> rtDao = new ReimbursementTypeDAO();
		return rtDao.get(typeId).getType();
	}

}
