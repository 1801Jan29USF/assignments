package com.revature.controller;

import java.io.IOException;
import java.util.List;

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

public class ReimbursementStatusController implements HttpController {

	private static Logger log = Logger.getRootLogger();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String reqUrl = req.getPathInfo();
		 int statusId = Integer.parseInt(reqUrl.substring(reqUrl.lastIndexOf("/")+1));
		 log.trace("User Id: " + statusId);
		 DAO<ReimbursementStatus> statusDao = new StatusDAO();
		 ReimbursementStatus status = statusDao.get(statusId);
		if (status != null) {
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(status);
			resp.setContentType("application/json");
			log.trace("JSON: " + json);
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
