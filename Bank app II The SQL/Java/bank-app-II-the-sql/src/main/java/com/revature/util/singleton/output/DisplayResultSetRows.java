package com.revature.util.singleton.output;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.beans.AccountName;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountNameDAO;
import com.revature.interfaces.DAO;

/**
 * Displays SQL query result sets that have multiple rows
 * 
 * @author Bobby McGetrick
 *
 */
public class DisplayResultSetRows {
	
	private static Logger log = Logger.getRootLogger();
	
	public List<Account> displayAccountsAndBalances(int userId) {
		log.trace("Creating new AccountDAO");
		AccountDAO accountDAO = new AccountDAO();
		log.trace("Retrieving all accounts associated with user id: " + userId);
		List<Account> accountList = accountDAO.getAllByUserId(userId);
		
		log.trace("Creating new AccountNameDAO");
		DAO<AccountName> accountNameDAO = new AccountNameDAO();
		
		log.trace("Creating float to store total amount atored accross all accounts");
		float total = 0;
		
		log.trace("Crating DecimalFormat for 2 deciaml places");
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setMaximumFractionDigits(2);
		
		log.trace("Iterating through list of accounts and displaying their name(s) and balance(s)");
		for (int i = 0; i < accountList.size(); i++) {
			log.trace("Displaying an account and it's current balance");
			String accountName = accountNameDAO.get(accountList.get(i).getAccountNameId()).getAccountName();
			System.out.println(i+1 + ": " + accountName + ": $" + decimalFormat.format(accountList.get(i).getBalance()));
			log.trace("Adding account " + accountName + "'s balance to the total");
			total += accountList.get(i).getBalance();
			
		}
		log.trace("Displaying total amount across all accounts");
		System.out.println("Total amount store in Revature Revenue: $" +  decimalFormat.format(total));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-------------------------------------------------------------------------------------------------");
		return accountList;
	}

}
