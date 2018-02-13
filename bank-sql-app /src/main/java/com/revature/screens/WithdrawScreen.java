package com.revature.screens;
 import com.revature.bean.Users;
import com.revature.dao.BankDAOJDBC;

import java.util.Scanner;

public class WithdrawScreen implements Screen {

	private Users user;
	

	

	Scanner amount = new Scanner (System.in);
	public BankDAOJDBC bd = new BankDAOJDBC();
//
//	public WithdrawScreen(Users user) {
//		super();
//		this.user = user;
//		// TODO Auto-generated constructor stub
//	}


	public WithdrawScreen(Users user) {
		// TODO Auto-generated constructor stub
		super();
		this.user = user;
	}


		
	
	@Override
	public Screen prompt() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the amount you would like to withdraw: ");
		
		int withdrawAmount = 0;
	
		
		try {
				withdrawAmount = Integer.parseInt(amount.nextLine());
		} catch (Exception e) {
			System.out.println("Number you enetered is not recognised ");
			return new UserActivityScreen(user);
			
		}
		
		if (withdrawAmount < 0) {
			System.out.println("Enter valid amount to withdraw. You may not withdraw "
					+ "amount that are less than 0");
			return new UserActivityScreen(user);
			
			
		}
		
		
		bd.withdraw(null, withdrawAmount);
		return new UserActivityScreen(user);
		
		
	}
}
