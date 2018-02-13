package com.revature.interfaces;

import java.util.List;

/**
 * MultiResultDAO generic interface
 * Extends DAO interface
 * 
 * DAO for handling results with multiple rows when searching
 * with specific ids
 * 
 * @author Bobby McGetrick
 *
 * @param <T>
 */
public interface MultiResultDAO<T> extends DAO<T> {

	/************************************************************************************
	 * Retrieve
	 ************************************************************************************/
	List<T> getAllByUserId(int userId);
	List<T> getAllByAccountId(int accountId);
	
}
