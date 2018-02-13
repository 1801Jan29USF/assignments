package com.revature.screens;

import java.util.Scanner;

import com.revature.bean.Users;
import com.revature.dao.BankDAOJDBC;

public class LoginScreen implements Screen{

	public LoginScreen() {
		super();
		//prompt();
	}
	
	public BankDAOJDBC bd = new BankDAOJDBC();
	Scanner pw = new Scanner (System.in);

	Scanner us = new Scanner (System.in);
	@Override
	public Screen prompt() {
		// TODO Auto-generated method stub
		System.out.println("Enter Username");
		
		String Username = us.nextLine();
		System.out.println("Enter Password");
	
		String Password = pw.nextLine();
		
		Users exist = bd.login(Username, Password);
//		if (exist == null){
//		System.out.println("You do not have an account, please signup");
//		return new BankMenu();
//		
//	}
//	else {
		System.out.println("Welcome to the Bank, Please select the option below: ");
			return new UserActivityScreen(exist);
		
			
		}

}
