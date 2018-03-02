package com.revature.controller;

import java.io.IOException;
import java.time.LocalDateTime;

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

public class ApprovalController implements HttpController {
	
	private static Logger log = Logger.getRootLogger();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String json = req.getReader().lines().reduce((acc, cur) -> acc + cur).get();
		log.trace("JSON: " + json);
		String reqUrl = req.getPathInfo();
		String statStr = reqUrl.substring(reqUrl.lastIndexOf("/") + 1);
		ObjectMapper om = new ObjectMapper();
		ReimbursementStatus s = new ReimbursementStatus(statStr);
		Reimbursement r = (Reimbursement) om.readValue(json, Reimbursement.class);
		DAO<ReimbursementStatus> sd = new StatusDAO();
		int statusId = sd.get(s).getId();
		r.setStatusId(statusId);
		r.setResolved(LocalDateTime.now());
		ReimbursementDAO rd = new ReimbursementDAO();
		rd.update(r);
		String respJson = om.writeValueAsString(rd.get(r.getId()));
		resp.getWriter().write(respJson);
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
