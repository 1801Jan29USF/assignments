package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Bank;

public class MainMenu implements Screen {

	private Scanner scan = new Scanner(System.in);
	private Bank bank;

	public MainMenu(Bank bank) {
		super();
		this.bank = bank;
	}

	@Override
	public Screen prompt() {
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
