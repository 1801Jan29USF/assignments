package com.revature.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
* Response Utility for the ERS
* Converts Objects into JSON and writes them to a HttpServletResponse
* 
* @author Bobby McGetrick
*
*/
public class ResponseUtil {
		
		/************************************************************************************
		 * Private fields
		 ************************************************************************************/
		 private static Logger log = Logger.getRootLogger();
		 
		 /************************************************************************************
		 * Constructors
		 ************************************************************************************/
		/**
		 * Create new ResponseUtil
		 */
		 public ResponseUtil() {
				super();
		}
		 
		/************************************************************************************
		 * hashCode() and equals()
		 ************************************************************************************/
		/**
		 * No non-static fields
		 */
		
		/************************************************************************************
		 * Getters and Setters
		 ************************************************************************************/
		/**
		 * Retrieve Object.log
		 * 
		 * @return Logger log
		 */
		 public static Logger getLog() {
			return log;
		}

		/**
		 * Set Object.log to a given Logger
		 * 
		 * @param Logger log
		 */
		public static void setLog(Logger log) {
			ResponseUtil.log = log;
		}
	
		/************************************************************************************
		 * Methods
		 ************************************************************************************/
		/**
		 * Take a given Object and convert it into a JSON String using
		 * ObjectMapper and write that JSON String to a HttpServletResponse
		 * 
		 * @param Object obj
		 * @param HttpServletResponse resp
		 * @throws IOException
		 * @throws ServletException
		 */
		public void writeObjectToResponse(Object obj, HttpServletResponse resp) throws IOException, ServletException {
			log.trace("Creting new ObjectMapper");
			ObjectMapper objectMapper = new ObjectMapper();
			log.trace("Converting Object " + obj + " to a JSON String");
			String json = objectMapper.writeValueAsString(obj);
			
			log.trace("Setting HttpServletResponse " + resp + " content type to JSON");
			resp.setContentType("application/json");
			log.trace("Writing JSON to the HttpServletResponse " + resp);
			resp.getWriter().println(json);
		}

}
