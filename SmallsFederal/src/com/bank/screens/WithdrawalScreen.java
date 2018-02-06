package com.bank.screens;

import java.util.Scanner;

import com.bank.beans.User;
import com.bank.file.io.UserSerializer;

public class WithdrawalScreen extends LoginScreen {

	private Scanner scan = new Scanner(System.in);
	private UserSerializer us = new UserSerializer();
	
	public User u = new User();
	
	public WithdrawalScreen(User u) {
		super();
		this.u = u;
	}
	
	public Screen prompt() {
		
		Withdraw();
		
		return new AccountScreen(u);
	}
	
	private void Withdraw() {
		
		System.out.println();
		System.out.println("Your current available balance is: " + u.getBalance());
		System.out.println("Please enter the amount you would like to withdraw: ");
		double amount = scan.nextDouble();
		System.out.println();
		if(amount < u.getBalance()) {
			u.setBalance(u.getBalance() - amount);
			System.out.println("Your account has been updated.");
			System.out.println("Your new available balance is: " + u.getBalance());
			System.out.println();
		}
		else {
			System.out.println("Insufficent funds in account, withdrawal cannot be made");
			System.out.println("Your available balance is: " + u.getBalance());
			System.out.println();
		}
		
		us.SerializeUser(u, u.getUserName() + ".txt");
	}
}
