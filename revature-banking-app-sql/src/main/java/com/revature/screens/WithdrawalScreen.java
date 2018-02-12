package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.BankDAOJDBC;

public class WithdrawalScreen implements Screen {

	private User curr;
	
	public Scanner scan = new Scanner(System.in);
	public BankDAOJDBC dao = new BankDAOJDBC();

	public WithdrawalScreen(User curr) {
		super();
		this.curr = curr;
		prompt();
	}

	@Override
	public Screen prompt() {
		System.out.println("WITHDRAWAL \n");
		System.out.println("Please Enter Amount for Withdrawal: ");
		int withdrawAmt = 0;
		try {
			withdrawAmt = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input for withdrawal\n");
			return new UserAccountScreen(curr);
		}
		if (withdrawAmt < 0) {
			System.out.println("Withdrawal amount must be greater or equal to 0\n");
			return new UserAccountScreen(curr);
		}
		System.out.println("Please enter the account that you would like to withdraw money from:");
		String acctName = scan.nextLine();
		dao.withdraw(curr.userId, withdrawAmt, acctName);
		return new UserAccountScreen(curr);
	}
}
