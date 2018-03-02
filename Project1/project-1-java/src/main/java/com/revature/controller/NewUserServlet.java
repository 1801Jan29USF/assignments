package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.newUser;
import com.revature.dao.ersDao;
import com.revature.dao.ersDaoJdbc;

public class NewUserServlet extends DefaultServlet {
	private ersDao ej = new ersDaoJdbc();
	private Logger log = Logger.getRootLogger();
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String json = request.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		log.trace("json " + json);
		ObjectMapper om = new ObjectMapper();
		newUser nu = (newUser) om.readValue(json, newUser.class);
		log.trace(nu);
		log.trace(nu);
		boolean succ = ej.createUser(nu);;
		if (succ) {
			log.trace("Successfully registered user");
			String j_son = om.writeValueAsString(succ);
			response.getWriter().write(j_son);
		} else {
			response.setStatus(401);
		}
	}

}
