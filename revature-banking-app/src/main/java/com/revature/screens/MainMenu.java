package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.Bank;

public class MainMenu implements Screen {

	private Scanner scan = new Scanner(System.in);

	public MainMenu(Bank bank) {
		super();
		prompt(bank);
	}

	@Override
	public Screen prompt(Bank bank) {
		System.out.println("Revature Banking");
		System.out.println("Please select an option: ");
		System.out.println("Enter 1 to Login");
		System.out.println("Enter 2 to Register");
		String input = scan.nextLine();

		switch (input) {
		
		case "1":
			return new LoginScreen(bank);
		case "2":
			return new RegisterScreen(bank);
		default:
			System.out.println("invalid option");
			break;
		}
		return new MainMenu(bank);
	}
}
