package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.beans.User;
import com.revature.dao.ersDao;
import com.revature.dao.ersDaoJdbc;

public class ReimbursementsServlet extends DefaultServlet {
	private ersDao ej = new ersDaoJdbc();
	private Logger log = Logger.getRootLogger();
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		log.trace("json " + json);
		ObjectMapper om = new ObjectMapper();
		User credentials = (User) om.readValue(json, User.class);
		log.trace(credentials);
		List<Reimbursement> rl = ej.getReimbursements(credentials);
		if (rl != null) {
			log.trace("Successful fetch");
			HttpSession sess = request.getSession();
			sess.setAttribute("reimbursements", rl);
			String j_son = om.writeValueAsString(rl);
			response.getWriter().write(j_son);
		} else {
			response.setStatus(401);
		}
	}

}
