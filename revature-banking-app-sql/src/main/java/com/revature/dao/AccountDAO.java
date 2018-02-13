package com.revature.dao;


/*Interface for the AccountDAO containing methods that
 * communicate with database
 */
public interface AccountDAO {
	
	void createAccount(int id, String name, String type);

	void deleteAccount(int id, String acctName);
}
