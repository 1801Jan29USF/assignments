package com.bank.screens;

import java.util.Scanner;

import com.bank.beans.User;
import com.bank.file.io.UserSerializer;

public class AccountScreen extends LoginScreen {
	private Scanner scan = new Scanner(System.in);
	private UserSerializer us = new UserSerializer();
	
	public User u = new User();
	
	public AccountScreen(User u) {
		super();
		//this.scan = scan;
		this.u = u;
	}

	@Override
	public Screen prompt() {
		// TODO Auto-generated method stub
		
		System.out.println();
		System.out.println(u.getUserName() + " you are now logged in");
		System.out.println();
		System.out.println("Enter 1 to view your Balance");
		System.out.println("Enter 2 to make a Deposit");
		System.out.println("Enter 3 to make a Withdrawal");
		System.out.println("Enter 4 to view Balance History");
		System.out.println("Enter 5 to logout");
		String input = scan.nextLine();
		
		switch(input) {
		case "1":
			return new BalanceScreen(u);
			
		case "2":
			return new DepositScreen(u);
			
		case "3":
			return new WithdrawalScreen(u);
			
		case "4":
			return new TranScreen(u);
			
		case "5":
			return new LogoutScreen();
			
		default:
			System.out.println("invalid option");
			break;
		}
		
		return new AccountScreen(u);
	}
}
