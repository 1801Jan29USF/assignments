package com.revature.bank.screens;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * The Main Menu screen is the start screen of the application. It prompt the user the option to 
 * login or register. The aplication always return to this screen, after user is logged off.
 * 
 */
import com.revature.bank.utility.BankSerializer;

public class MainMenu implements Screen {
	
	private Logger log = Logger.getRootLogger();

	private Scanner scan = new Scanner(System.in);
	private BankSerializer bs = new BankSerializer();

	public Screen prompt() {

		System.out.println("Welcome to Revature Bank");
		System.out.println("Please select an option.");
		System.out.println("Enter 1 to Login");
		System.out.println("Enter 2 to register");

		String input = scan.nextLine();

		switch (input) {
		case "1":
			return new LoginScreen();
			
		case "2":
			 return new AddUserScreen() ;

		default:
			System.out.println("invalid option");
			break;
		}

		return new MainMenu();
	}
	
	
		
	

}
