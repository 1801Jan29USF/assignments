package com.revature.screens;

import java.util.Scanner;

import com.revature.bank.Bank;
import com.revature.beans.User;
import com.revature.interfaces.Screen;
/**
 * logic for the main menu
 * @author Matt
 *
 */
public class Menu implements Screen{

	@Override
	public Screen prompt() {
		Bank bank = Bank.getBank();
		User currentUser = bank.getCurrentUser();
		Scanner scan = new Scanner(System.in);
		System.out.println("Make a selection: ");
		System.out.println("1: Make a Deposit");
		System.out.println("2: Make a Withdrawal");
		System.out.println("3: View Balance");
		System.out.println("4: View Transaction History");
		System.out.println("5: Logout\n");
		switch(scan.nextLine()) {
			
		case "1":
			System.out.println("Enter amount to deposit: ");
			bank.deposit(currentUser, scan.nextDouble());
			System.out.println("Your balance is: " + currentUser.getBalance());
			return new Menu();
		case "2":
			System.out.println("Enter amount to withdraw: ");
			bank.withdraw(currentUser, scan.nextDouble());
			System.out.println("Your balance is: " + currentUser.getBalance());
			return new Menu();
		case "3":
			System.out.println("Your balance is: " + currentUser.getBalance());
			return new Menu();
		case "4": 
			bank.getTransactions(currentUser.getUsername());
			return new Menu();
		case "5":
			System.out.println("Logged out successfully");
			return new Login();
		default:
			System.out.println("Command not understood");
			return new Menu();
		}
	}

}
