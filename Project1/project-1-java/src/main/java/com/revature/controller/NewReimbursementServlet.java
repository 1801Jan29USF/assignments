package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ReimbRequest;
import com.revature.beans.User;
import com.revature.dao.ersDao;
import com.revature.dao.ersDaoJdbc;

public class NewReimbursementServlet extends DefaultServlet {
	private ersDao ej = new ersDaoJdbc();
	private Logger log = Logger.getRootLogger();
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		log.trace("json " + json);
		ObjectMapper om = new ObjectMapper();
		ReimbRequest rReq = (ReimbRequest) om.readValue(json, ReimbRequest.class);
		log.trace(rReq);
		boolean succ = ej.logReimbursementRequest(rReq);
		if (succ) {
			log.trace("Successfully registered reimbursement");
			String j_son = om.writeValueAsString(succ);
			response.getWriter().write(j_son);
		} else {
			response.setStatus(401);
		}
	}
}
