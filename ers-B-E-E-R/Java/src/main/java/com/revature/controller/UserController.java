package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.interfaces.HttpController;
import com.revature.service.UserService;
import com.revature.util.ResponseUtil;

/**
 * User Controller for the employee reimbursement system Handles requests
 * related to /user/login URLs
 * 
 * @author Bobby McGetrick
 *
 */
public class UserController implements HttpController {

	/************************************************************************************
	 * Private fields
	 ************************************************************************************/
	private Logger log = Logger.getRootLogger();
	private static final String USER_LOGIN_URL = "/user/login";
	private UserService userService = new UserService();
	private ResponseUtil respUtil = new ResponseUtil();

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	/**
	 * Create new UserController
	 */
	public UserController() {
		super();
	}

	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	/**
	 * Generate Object hash code
	 */
	@Override
	public int hashCode() {
		log.info("Generating UserController hash code");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((log == null) ? 0 : log.hashCode());
		log.info("Returning UserController hash code");
		return result;
	}

	/**
	 * Check if Object is equivalent to another Object
	 * 
	 * @param Object
	 *            obj
	 */
	@Override
	public boolean equals(Object obj) {
		log.info("Checking if UserControlelr is equivalent to the passed Object " + obj);
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserController other = (UserController) obj;
		if (log == null) {
			if (other.log != null)
				return false;
		} else if (!log.equals(other.log))
			return false;
		return true;
	}

	/************************************************************************************
	 * Getters and Setters
	 ************************************************************************************/
	/**
	 * Retrieve UserController.log
	 * 
	 * @return Logger log
	 */
	public Logger getLog() {
		return log;
	}

	/**
	 * Set UserController.log to a given Logger
	 * 
	 * @param Logger
	 *            log
	 */
	public void setLog(Logger log) {
		this.log = log;
	}

	/**
	 * Retrieve UserController.USER_LOGIN_URL
	 * 
	 * @return String USER_LOGIN_URL
	 */
	public static String getUserUrl() {
		return USER_LOGIN_URL;
	}

	/************************************************************************************
	 * Overrides
	 ************************************************************************************/
	/**
	 * If a Get request if sent to the login page forward the user back to the login
	 * page so that they need to login before they can continue
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String reqUrl = req.getPathInfo();
		int userId = Integer.parseInt(reqUrl.substring(reqUrl.lastIndexOf("/") + 1));
		UserDAO ud = new UserDAO();
		User u = ud.get(userId);
		if (u != null) {
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(u);
			resp.setContentType("application/json");
			log.trace("JSON: " + json);
			resp.getWriter().println(json);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		log.trace("Post request made to User Controller");
		log.trace("user name = " + req.getParameter("userName"));
		log.trace("Convert the body of the Post request to a JSON String");
		String json = req.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		log.trace("JSON: " + json);

		log.trace("Creating new ObjectMapper");
		ObjectMapper objectMapper = new ObjectMapper();

		log.trace("Creating new User with information rom the JSON String");
		User credentials = (User) objectMapper.readValue(json, User.class);
		log.trace("User credentials: " + credentials);
		log.trace("Creating a new User with data from the ERS database");
		User user = userService.login(credentials.getUsername(), credentials.getPassword());

		log.trace("Checking credentials where null");
		if (user != null) {
			log.trace("Credentials where valid");
			log.trace("Creaaing new HttpSession");
			// HttpSession session = req.getSession();
			// log.trace("Setting the user attribute of the session to the logged in User");
			// session.setAttribute("user", user);
			String respJson = objectMapper.writeValueAsString(user);
			resp.getWriter().write(respJson);
		} else {
			log.trace("Login credentials invalid - setting response status to 401");
			resp.setStatus(401);
		}
	}

	@Override
	public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

}
