package com.revature.interfaces;

/**
 * JunctionDAO generic interface
 * Extends DAO interface
 * 
 * DAO for handling junction tables
 * 
 * @author Bobby McGetrick
 *
 * @param <T>
 */
public interface JunctionDAO<T> extends DAO<T> {

	/************************************************************************************
	 * Retrieve
	 ************************************************************************************/
	T getByCompositeKey(int foreignKey0, int foreignKey1);
	
}
