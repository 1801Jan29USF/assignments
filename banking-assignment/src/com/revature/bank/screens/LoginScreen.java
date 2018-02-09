package com.revature.bank.screens;

import java.io.File;
import java.util.Scanner;

import com.revature.bank.bean.User;
import com.revature.bank.utility.BankSerializer;

/**
 * This Login screen allows user to login to account. If invalid 
 * user name and/or password are invalid * it return user to Main menu. 
 * If both user and password pass, it takes them to user screen page.
 * @author Ahmed
 *
 */

public class LoginScreen implements Screen {

	@Override
	public Screen prompt() {
		Scanner scan = new Scanner(System.in);
		BankSerializer bs = new BankSerializer();
		User user = new User();

		System.out.println("------Log in------");
		System.out.println("Please enter a username");
		String username = scan.nextLine();

		System.out.println("Please enter a password");
		String password = scan.nextLine();

		File f = new File(username + ".txt");
		if (f.exists()) {

			//user = bs.DeserializeBank(username);
			if (!password.equals(user.getPassword())) {
				System.out.println("Loging was not successful. Try again!");
				System.out.println("<----------------------------------->");
				return new MainMenu();

			} else {

				System.out.println("You have sucessfully loged in");
				System.out.println("<----------------------------------->");
				System.out.println("Welcome " + user.getUserName());
				return new UserScree(user);

			}

		}
		System.out.println("Try again!");
		return new MainMenu();

	}
}
