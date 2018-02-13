package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.BankDAOJDBC;

public class MainMenu implements Screen {
	private Scanner scan = new Scanner(System.in);
	private BankDAOJDBC bd = new BankDAOJDBC();

	@Override
	public Screen prompt() {
		System.out.println("Welcome to the Bank of Monsters. We hope you enjoy your time here!");
		System.out.println("Please select an option: ");
		System.out.println("Enter 1 to login to the Bank of Monsters.");
		System.out.println("Enter 2 to create an account.");
		System.out.println("Enter 3 to exit the Bank of Monsters.");

		String input = scan.nextLine();

		switch (input) {
		case "1":
			System.out.println("Enter your monster name: ");
			String userName = scan.nextLine();
			
			System.out.println("Enter your password: ");
			String password = scan.nextLine();

			User u = User.getUser();
			
			u.setUsername(userName);
			u.setPassword(password);
			bd.getUser(userName);
			u.setBalance(bd.getUser(userName).getBalance());
			
			if(u.getUsername() == null && bd.getUser(userName).getUsername() == null) {
				System.out.println("Invalid username.");
				
				return new MainMenu();
			} else if(u.getPassword() == null && bd.getUser(userName).getPassword() == null) {
				System.out.println("Invalid password.");
				
				return new MainMenu();
			} else if(u.getUsername().equals(bd.getUser(userName).getUsername()) && u.getPassword().equals(bd.getUser(userName).getPassword())) {
				System.out.println("You have successfully logged in.\n");
				
				return new AccountScreen();
				
			} else {
				System.out.println("Incorrect monster name or password. Returning to the main menu. \n");
				
				return new MainMenu();
			}
			
		case "2":
			addUser();
			
			break;
			
		case "3":
			System.out.println("Thanks for coming to the Bank of Monsters. Have a good day!");
			System.exit(0);

		default:
			System.out.println("Invalid option.");
			
			break;
		}
		return new MainMenu();
	}
	
	private void addUser() {
		System.out.println("Enter your monster name: ");
		String userName = scan.nextLine();
		
		System.out.println("Enter your desired password: ");
		String password = scan.nextLine();
		
		System.out.println("Enter your current balance: ");
		double balance = 1000;
		try {
			balance += Double.parseDouble(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input.");
		}

		User u = User.getUser(0, userName, password, balance);
		bd.addUser(u);
		System.out.println("You've been added to the Bank of Monsters!");
		System.out.println("Enjoy your complementary 1000 dollars.");
	}
}