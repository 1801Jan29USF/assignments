package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.BankDAOJDBC;

public class TransferScreen implements Screen {

	private User curr;
	
	public Scanner scan = new Scanner(System.in);

	public BankDAOJDBC dao = new BankDAOJDBC();

	public TransferScreen(User curr) {
		super();
		this.curr = curr;
		prompt();
	}

	@Override
	public Screen prompt() {
		System.out.println("TRANSFER \n");
		System.out.println("Which account would you like to transfer to?\n");
		String type = scan.nextLine();
		System.out.println("Enter amount for transfer\n");
		int transferAmt = 0;
		try {
			transferAmt = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input for transfer\n");
			return new UserAccountScreen(curr);
		}
		if (transferAmt < 0) {
			System.out.println("Transfer amount must be greater or equal to 0\n");
			return new UserAccountScreen(curr);
		}
		dao.transfer(curr.getId(), transferAmt, type);
		return new UserAccountScreen(curr);
	}

}
