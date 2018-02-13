package com.revature.screens;

import java.util.Scanner;

import com.revature.bean.Users;
import com.revature.dao.BankDAOJDBC;

public class UserActivityScreen implements  Screen {

		private Users user;

		public UserActivityScreen(Users user){
			super();
			this.user = user;
			//prompt();
		}

		Scanner scan = new Scanner (System.in);
		
		public BankDAOJDBC db = new BankDAOJDBC();
	@Override
	public Screen prompt() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to your account, please select the option below: ");
		System.out.println("Enter 1 to view Balance ");
		System.out.println("Enter 2 to Deposit ");
		System.out.println("Enter 3 to Withdraw ");
		System.out.println("Enter 4 to view Transaction ");
		System.out.println("Enter 5 logout ");
		
	
		String input = scan.next();

		switch (input) {
		case "1": 
		//	System.out.println("The balance for " + user.getUsername() + " is " + db.viewBalance(user.getUserId(), user.getUsername()));
			return new BalanceScreen(user);
		case "2": 
			return new DepositScreen(user);
		case "3": 
			return new WithdrawScreen(user);
		case "4": 
			db.displayTransaction(user.getUserId());
		case "5": 
			return new BankMenu();
					
		default: 
				System.out.println("choose valid option");
				break;
		}
		
		return new UserActivityScreen(user);
	}
	}


