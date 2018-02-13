package com.revature.screens;

import java.util.Scanner;

import com.revature.bean.Users;
import com.revature.dao.BankDAOJDBC;

public class BalanceScreen implements Screen{

	
	private Users user;

	public BalanceScreen(Users user) {
		
		super();
		this.user= user;
		//prompt();
	}
	
	
	public BankDAOJDBC bd = new BankDAOJDBC();
	Scanner pw = new Scanner (System.in);
	
	
	
	@Override
	public Screen prompt() {
		// TODO Auto-generated method stub
		System.out.println("Enter account name for which you like to see the balace for ");
		String username = pw.nextLine();
		bd.viewBalance(0, username);

		
		return null;
	}

}
