package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.dao.BankDAOJDBC;

public class RegisterScreen implements Screen {

	public Scanner scan = new Scanner(System.in);
	public BankDAOJDBC dao = new BankDAOJDBC();
	
	public RegisterScreen() {
		super();
		prompt();

	}

	@Override
	public Screen prompt() {
		System.out.println("ACCOUNT REGISTRATION \n");
		//added exit functionality in last minute, not the best style :(
		System.out.println("Please enter your Username or enter exit to return to Main Menu.\n");
		String input = scan.nextLine();
		if (input.hashCode() == "exit".hashCode()) {
			return new MainMenu();
		}
		System.out.println("Please enter your Password: ");
		String password = scan.nextLine();
		User current = dao.register(input, password);
		if (current != null) {
			System.out.println("Congratulations, your account has been created.\n");
			return new UserAccountScreen();

		} else {
			System.out.println("Account already exists. Please pick a different Username.\n");
			return new MainMenu();
		}

	}

}
