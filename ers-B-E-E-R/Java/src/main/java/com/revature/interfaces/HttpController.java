package com.revature.interfaces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface HttpController {
	
	/************************************************************************************
	 * Get
	 ************************************************************************************/
	void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
	
	/************************************************************************************
	 * Post
	 ************************************************************************************/
	void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
	
	/************************************************************************************
	 * Put
	 ************************************************************************************/
	void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
	
	/************************************************************************************
	 * Delete
	 ************************************************************************************/
	void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;

}
