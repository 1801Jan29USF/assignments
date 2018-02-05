package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.util.BankSerializer;

public class MainMenu implements Screen {
	private Scanner scan = new Scanner(System.in);
	private BankSerializer bs = new BankSerializer();

	@Override
	public Screen prompt() {
		System.out.println("Please select an option: ");
		System.out.println("Enter 1 to login to our bank.");
		System.out.println("Enter 2 to create an account.");
		System.out.println("Enter 3 to exit our bank.");

		String input = scan.nextLine();

		switch (input) {
		case "1":
			System.out.println("Enter your username: ");
			String userName = scan.nextLine();
			
			System.out.println("Enter your password: ");
			String password = scan.nextLine();

			User u = User.getUser();
			
			u.setUsername(userName);
			u.setPassword(password);
			bs.getUser(userName);
			
			if(u.getUsername() == null && bs.getUser(userName).getUsername() == null) {
				System.out.println("Invalid username.");
				
				return new MainMenu();
			} else if(u.getPassword() == null && bs.getUser(userName).getPassword() == null) {
				System.out.println("Invalid password.");
				
				return new MainMenu();
			} else if(u.getUsername().equals(bs.getUser(userName).getUsername()) && u.getPassword().equals(bs.getUser(userName).getPassword())) {
				System.out.println("You have successfully logged in.\n");
				
				return new AccountScreen();
				
			} else {
				System.out.println("Incorrect username or password. Returning to the main menu. \n");
				
				return new MainMenu();
			}
			
		case "2":
			addUser();
			
			break;
			
		case "3":
			System.out.println("Thanks for coming. Have a good day!");
			System.exit(0);

		default:
			System.out.println("Invalid option.");
			
			break;
		}
		return new MainMenu();
	}
	
	private void addUser() {
		System.out.println("Enter your name: ");
		String userName = scan.nextLine();
		
		System.out.println("Enter your desired password: ");
		String password = scan.nextLine();
		
		System.out.println("Enter your current balance: ");
		int balance = 0;
		try {
			balance = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input.");
		}

		User u = User.getUser(userName, password, balance);
		bs.addUser(u, userName);
		System.out.println("You've been added!");
	}
}