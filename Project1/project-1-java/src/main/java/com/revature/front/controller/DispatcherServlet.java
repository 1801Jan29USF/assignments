package com.revature.front.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.log4j.Logger;

import com.revature.controller.LoginServlet;
import com.revature.controller.NewReimbursementServlet;
import com.revature.controller.NewUserServlet;
import com.revature.controller.ReimbursementsServlet;
import com.revature.controller.ResolveReimbursementServlet;

public class DispatcherServlet extends DefaultServlet {
	private Logger log = Logger.getRootLogger();
	private LoginServlet ls = new LoginServlet();
	private ReimbursementsServlet rs = new ReimbursementsServlet();
	private ResolveReimbursementServlet rrs = new ResolveReimbursementServlet();
	private NewReimbursementServlet nrs = new NewReimbursementServlet();
	private NewUserServlet nus = new NewUserServlet();
	
	
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
		log.trace(request.getParameter("username"));
		String url = request.getPathInfo();
		log.trace("Get request made with path " + url);
		if (url.startsWith("/static/")) {
			super.doGet(request, response);
			return;
		} 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String url = request.getPathInfo();
		log.trace("Post request made with path " + url);
		if (url.startsWith("/login")) {
			ls.doPost(request, response);
		} else if (url.startsWith("/reimbursements")) {
			rs.doPost(request, response);
		} else if (url.startsWith("/resolve")) {
			rrs.doPost(request, response);
		} else if (url.startsWith("/newreimbursement")) {
			nrs.doPost(request, response);
		} else if (url.startsWith("/register")) {
			nus.doPost(request, response);
		}
	
}
}
