package com.bank.screens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.beans.AuthUser;
import com.bank.dao.BankDAOJDBC;
import com.bank.dao.bankDAO;
//import com.bank.util.UserSerializer;
import com.bank.screens.MainMenu;
import com.bank.screens.LoginScreen;

/**
 * First screen encountered in banking application. Searches our list of users
 * for their given input, and returns the main menu screen if it's a match!
 *
 */
public class LoginScreen implements Screen {

	private int currentUserID;

	private Logger log = Logger.getRootLogger();

	Scanner scan = new Scanner(System.in);

	bankDAO bdao = BankDAOJDBC.getBdao();

	@Override
	public Screen prompt() {
		
		System.out.println(("Welcome to Revature Banking. Enter your username, or type New to make a new account."));
		String inputname = scan.nextLine();

		// if the input is "new", gives sends to register screen!
		if (inputname.toLowerCase().equalsIgnoreCase("new")) {
			return new RegisterScreen().prompt();

		} else {

			System.out.println("Enter your password.");

			String inputpass = scan.nextLine();

			bdao.login(inputname, inputpass);

			if (bdao.getCurrentUserID() > 0) {
				return new MainMenu().prompt();
			}

		}

		return null;
	}

}
