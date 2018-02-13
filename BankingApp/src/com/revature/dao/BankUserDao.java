package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Transaction;
import com.revature.exceptions.InvalidPasswordException;
import com.revature.exceptions.OverdraftException;

public interface BankUserDao {
	
	public void withdraw(String username, String password, Double amount) throws SQLException, OverdraftException, InvalidPasswordException;
	
	public void deposit(String username, Double amount) throws SQLException;
	
	public List<Transaction> getTransactionHistory(String username) throws SQLException;
	
	public Double getBalance(String username) throws SQLException;

}
