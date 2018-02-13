package com.revature.screens;

import java.util.Scanner;

import com.revature.bean.Users;
import com.revature.dao.BankDAOJDBC;

public class SignupScreen implements Screen{
	

	public BankDAOJDBC bd = new BankDAOJDBC();
	
	public SignupScreen() {
		super();
	//	prompt();
	}
	Scanner pw = new Scanner(System.in);
	
	Scanner us = new Scanner(System.in);
	public Screen prompt() {
		// TODO Auto-generated method stub
		
		
		System.out.println("Please Sign up with username and password");
		
		System.out.println("Enter username");
	
		String Username = us.next();
		
		System.out.println("Enter password");
	
		String Password = pw.next();
		
		Users exist = bd.signup(Username, Password);
//		if (exist != null){
//		
//		System.out.println("Sucessfully Signed up for the bank");
//		return new BankMenu();
////			
//		}
//	else {
//		System.out.println("unable to signup, pick a different username");
//		return new UserActivityScreen(exist);
//			
		return new UserActivityScreen(exist);
		}

}