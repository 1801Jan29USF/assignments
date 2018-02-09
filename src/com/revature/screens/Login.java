package com.revature.screens;

import java.util.Scanner;

import com.revature.bank.Bank;
import com.revature.beans.User;
import com.revature.interfaces.Screen;
/**
 * Logic for the login screen
 * @author Matt
 *
 */
public class Login implements Screen{

	@Override
	public Screen prompt() {
		Bank bank = Bank.getBank();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Username:");
		String username = scan.nextLine();
		System.out.println("Enter Password");
		String password = scan.nextLine();
		
		User user = bank.validateLogin(username, password);
		if(user != null){
			bank.setCurrentUser(user);
			return new Menu();
		}
		return new Login();
	}
	
	
}
