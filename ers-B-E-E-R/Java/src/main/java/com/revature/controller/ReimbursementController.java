package com.revature.controller;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.beans.ReimbursementStatus;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.StatusDAO;
import com.revature.interfaces.DAO;
import com.revature.interfaces.HttpController;

/**
 * Reimbursement Controller for the employee reimbursement system Handles
 * requests related to /reimbursement URLs
 * 
 * @author Bobby McGetrick
 *
 */
public class ReimbursementController implements HttpController {
	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new Object
	 */

	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate Object hash code
	 */
	// log.info("Generating Object hash code");
	// log.info("Returning Object hash code");

	/**
	 * Check if Object is equivalent to another Object
	 * 
	 * @param Object
	 *            obj
	 */
	// log.info("Checking if Object is equivalent to the passed Object " + obj );

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
	 * @param Logger
	 *            log
	 */
	// public static void setLog(Logger log) {
	// Object.log = log;
	// }

	/************************************************************************************
	 * Overrides
	 ************************************************************************************/
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String reqUrl = req.getPathInfo();
		List<Reimbursement> reimbList = new Vector<Reimbursement>();
		if (reqUrl.charAt(reqUrl.length() - 1) != '/') {
			int userId = Integer.parseInt(reqUrl.substring(reqUrl.lastIndexOf("/") + 1));
			log.trace("User Id: " + userId);
			ReimbursementDAO reimbDAO = new ReimbursementDAO();
			reimbList = reimbDAO.getAll(userId);
		} else {
			ReimbursementDAO reimbDAO = new ReimbursementDAO();
			reimbList = reimbDAO.getAll();
		}
		if (reimbList != null) {
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(reimbList);
			resp.setContentType("application/json");
			log.trace("Reimb List JSON: " + json);
			resp.getWriter().println(json);
		} else {
			resp.setStatus(401);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String json = req.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		log.trace("JSON: " + json);
		ObjectMapper om = new ObjectMapper();
		Reimbursement newReimb = (Reimbursement) om.readValue(json, Reimbursement.class);
		if (newReimb != null) {
			DAO<Reimbursement> reimbDAO = new ReimbursementDAO();
			reimbDAO.create(newReimb);
			String respJson = om.writeValueAsString(newReimb);
			resp.getWriter().write(respJson);
		} else {
			log.trace("Login credentials invalid - setting response status to 401");
			resp.setStatus(401);
		}

		// ObjectMapper objectMapper = new ObjectMapper();
		// Reimbursement reimbReq = (Reimbursement) objectMapper.readValue(json,
		// Reimbursement.class);
		// List<Reimbursment> reimbList =
		// reimbService.retrieveUserReimburements(userId);
	}

	@Override
	public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String json = req.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		log.trace("JSON: " + json);
		String reqUrl = req.getPathInfo();
		String statStr = reqUrl.substring(reqUrl.lastIndexOf("/") + 1);
		ObjectMapper om = new ObjectMapper();
		ReimbursementStatus s = new ReimbursementStatus(statStr);
		Reimbursement r = (Reimbursement) om.readValue(json, Reimbursement.class);
		DAO<ReimbursementStatus> sd = new StatusDAO();
		int statusId = sd.get(s).getId();
		ReimbursementDAO rd = new ReimbursementDAO();
		rd.update(r);
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

	/************************************************************************************
	 * Methods
	 ************************************************************************************/
}
