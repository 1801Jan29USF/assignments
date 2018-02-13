package com.revature.screens;

import java.util.Scanner;

import com.revature.bean.Users;
import com.revature.dao.BankDAOJDBC;

public class DepositScreen implements Screen {
	public BankDAOJDBC bd = new BankDAOJDBC();
	private Users user;

	public DepositScreen(Users user) {
		super();
		this.user = user;

	}
	Scanner amount = new Scanner (System.in);
	

	@Override
	public Screen prompt() {
		// TODO Auto-generated method stub
		
			System.out.println("Enter the amount you would like to deposite: ");
			System.out.println("Deposite must be greater than $0 ");
			int  depositAmount = 0;		
			try {
				depositAmount = Integer.parseInt(amount.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid input for deposit\n");
				return new UserActivityScreen(this.user);
			}
			if (depositAmount == 0.0 ) {
				System.out.println("You may not deposite $0.00");
				System.out.println("enter amount greater than $0.00");
			}
			if (depositAmount < 0) {
				System.out.println("You may not deposite amount less than 0");
				return new UserActivityScreen(user);
			}
			
		System.out.println("account name for the deposit");
		String account_name = amount.nextLine();
		System.out.println("enter your acount_id ");
		int user_id = amount.nextInt();
		bd.deposit(depositAmount, account_name, user_id);
		
		return new UserActivityScreen(user);
	
	}

}
