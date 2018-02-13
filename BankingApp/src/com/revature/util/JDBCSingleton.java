package com.revature.util;

import com.revature.dao.BankUserDaoJDBC;

public class JDBCSingleton {
	private static JDBCSingleton js = new JDBCSingleton();
	private static BankUserDaoJDBC jd = new BankUserDaoJDBC();
	
	private JDBCSingleton() {
		super();
	}
	
	public static BankUserDaoJDBC getJD() {
		return jd;
	}

}
