package com.revature.screens;

import java.util.Scanner;

public class BankMenu implements Screen{

	public BankMenu() {
		super();
	//	prompt();
	}
	
	Scanner scan = new Scanner (System.in);
	@Override
	public Screen prompt() {
		// TODO Auto-generated method stub

			System.out.println("Welcome to the Bank APP !!!");
			System.out.println("Please choose an option to begin ");
			System.out.println("Enter 1 to Signup");
			System.out.println("Enter 2 to Login");
			
					
					
			String input = scan.nextLine();

			switch (input) {

			case "1":
				return new SignupScreen();
			 case "2":
			 return new LoginScreen();
			default:
				System.out.println("invalid option\n");
				break;
			}
			return new BankMenu();
		}
	
	}
