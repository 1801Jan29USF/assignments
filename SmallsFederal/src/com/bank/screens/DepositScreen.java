package com.bank.screens;

import java.util.Scanner;

import com.bank.beans.User;
import com.bank.file.io.UserSerializer;

public class DepositScreen extends LoginScreen {

	private Scanner scan = new Scanner(System.in);
	private UserSerializer us = new UserSerializer();
	
	public User u = new User();
	
	public DepositScreen(User u) {
		super();
		//this.scan = scan;
		this.u = u;
	}
	
	public Screen prompt() {
		
		Deposit();
		
		return new AccountScreen(u);
	}
	
	private void Deposit() {
		
		System.out.println();
		System.out.println("Your current available balance is: " + u.getBalance());
		System.out.println("Please enter the amount you would like to deposit: ");
		double amount = scan.nextDouble();
		System.out.println();
		u.setBalance(u.getBalance() + amount);
		System.out.println("Your account has been updated.");
		System.out.println("Your new available balance is: " + u.getBalance());
		System.out.println();
		
		us.SerializeUser(u, u.getUserName() + ".txt");	
	}
}
