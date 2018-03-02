package com.revature.front.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.controller.ApprovalController;
import com.revature.controller.ReimbursementController;
import com.revature.controller.ReimbursementStatusController;
import com.revature.controller.ReimbursementTypeController;
import com.revature.controller.RoleController;
import com.revature.controller.UserController;

/**
 * Front Controller for the employee reimbursement system Delegates requests to
 * appropriate controllers based on a given URL
 * 
 * @author Bobby McGetrick
 *
 */
public class DispatcherServlet extends DefaultServlet {

	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private static Logger log = Logger.getRootLogger();
	private UserController userController = new UserController();
	// private UserRoleController userRoleController = new UserRoleController();
	private ReimbursementController reimbursementController = new ReimbursementController();
	// ReimbursementController();
	private ReimbursementTypeController reimbursementTypeController = new ReimbursementTypeController();
	private ReimbursementStatusController reimbursementStatusController = new ReimbursementStatusController();
	private ApprovalController ac = new ApprovalController();
	private RoleController rc = new RoleController();
	
	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new User
	 */
	public DispatcherServlet() {
		super();
		log.info("Constructing new DispatcherServlet");
		log.info("Called super constructor - Object");
		log.info("New DispatcherServlet created");
	}

	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate DispatcherServlet hash code
	 */
	// log.info("Generating DispatcherServlet hash code");
	// log.info("Returning DispatcherServlet hash code");

	/**
	 * Check if DispatcherServlet is equivalent to another Object
	 * 
	 * @param Object
	 *            obj
	 */
	// log.info("Checking if DispatcherServlet is equivalent to the passed Object "
	// + obj );

	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve DispatcherServlet.log
	 * 
	 * @return Logger log
	 */
	public static Logger getLog() {
		return log;
	}

	/**
	 * Set DispatcherServlet.log to a given Logger
	 * 
	 * @param Logger
	 *            log
	 */
	public static void setLog(Logger log) {
		DispatcherServlet.log = log;
	}

	/************************************************************************************
	 * Overrides
	 ************************************************************************************/
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers",
				"Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url = request.getPathInfo();
		log.info("Get request made with path " + url);
		// if (request.getSession().getAttribute("user") != null) {
		if (url.startsWith("/reimbursement")) {
			reimbursementController.doGet(request, response);
		}
		/* } */ else if (url.startsWith("/login")) {
			log.trace("Login page requested - calling UserController doGet");
			userController.doGet(request, response);
		} else if (url.startsWith("/type")) {
			reimbursementTypeController.doGet(request, response);
		} else if (url.startsWith("/user")) {
			userController.doGet(request, response);
		} else if (url.startsWith("/status")) {
			reimbursementStatusController.doGet(request, response);
		} else if (url.startsWith("/role")) {
			rc.doGet(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url = request.getPathInfo();
		if (url.startsWith("/reimbursement")) {
			log.trace("PAst tickets page requested - calling UserController doGet");
			reimbursementController.doPost(request, response);
		} else if (url.startsWith("/login")) {
			userController.doPost(request, response);
		} else if (url.startsWith("/approval")) {
			ac.doPost(request, response);
		}
	}

}
