package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ResolutionRequest;
import com.revature.beans.User;
import com.revature.dao.ersDao;
import com.revature.dao.ersDaoJdbc;

public class ResolveReimbursementServlet extends DefaultServlet {
	private ersDao ej = new ersDaoJdbc();
	private Logger log = Logger.getRootLogger();
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// using JSON
		String json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		log.trace("json " + json);
		ObjectMapper om = new ObjectMapper();
		ResolutionRequest resQ = (ResolutionRequest) om.readValue(json, ResolutionRequest.class);
		log.trace(resQ);
		boolean suc = ej.setResolved(resQ);
		if (suc) {
			log.trace("Successful login");
			String j_son = om.writeValueAsString(suc);
			response.getWriter().write(j_son);
		} else {
			response.setStatus(401);
		}
	}
	

}
