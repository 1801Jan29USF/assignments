package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.beans.UserRole;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.UserRoleDAO;
import com.revature.interfaces.HttpController;

public class RoleController implements HttpController {
	
	private static Logger log = Logger.getRootLogger();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String reqUrl = req.getPathInfo();
		int roleId = Integer.parseInt(reqUrl.substring(reqUrl.lastIndexOf("/") + 1));
		log.trace("Role Id: " + roleId);
		UserRoleDAO roleDAO = new UserRoleDAO();
		UserRole ur = roleDAO.get(roleId);
		if (ur != null) {
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(ur);
			resp.setContentType("application/json");
			log.trace("Reimb List JSON: " + json);
			resp.getWriter().println(json);
		} else {
			resp.setStatus(401);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
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
