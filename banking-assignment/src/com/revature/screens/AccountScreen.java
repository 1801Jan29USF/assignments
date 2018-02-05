package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.util.BankSerializer;

public class AccountScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private BankSerializer bs = new BankSerializer();
	private User u = User.getUser();

	@Override
	public Screen prompt() {
		System.out.println("Please select an option: ");
		System.out.println("Enter 1 to deposit to your account.");
		System.out.println("Enter 2 to withdraw from your account.");
		System.out.println("Enter 3 to view your balance.");
		System.out.println("Enter 4 to go back to the main menu.");
		
		String input = scan.nextLine();
		
		switch (input) {
		case "1":
			System.out.println("Please insert the amount you would like to deposit: ");
			int balance = 0;
			try {
				balance = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input.");
			}
			
			u.setBalance(u.getBalance() + balance);
			bs.serializeBank(u, u.getUsername());
			
			System.out.println("You have input " + balance + " into your bank account.");
			System.out.println("Your current total is: " + u.getBalance() + "\n");
			
			return new AccountScreen();
			
		case "2":
			System.out.println("Please insert the amount you would like to withdraw: ");
			int balance1 = 0;
			try {
				balance1 = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input.");
			}
			
			u.setBalance(u.getBalance() - balance1);
			bs.serializeBank(u, u.getUsername());
			
			System.out.println("You have withdrawn " + balance1 + " from your bank account.");
			System.out.println("Your current total is: " + u.getBalance() + "\n");
			
			return new AccountScreen();
			
		case "3":
			System.out.println("Your balance is: " + u.getBalance());
			
			return new AccountScreen();
			
		case "4":
			return new MainMenu();
			
		default:
			System.out.println("Invalid option.");
			
			break;
		}
		return new MainMenu();
	}
}