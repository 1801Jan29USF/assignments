package com.revature.BankingApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class UserRegister implements ScreenBank {
		DatabaseDAO dao = new DatabaseDAO();
		private Scanner in = new Scanner(System.in);
		private Logger log = Logger.getRootLogger();

		
			@Override
			public ScreenBank prompt() {	
				
	
					System.out.println("Welcome New Customer! Please enter the username you want to register:");
					String Username = in.nextLine();
					//gets the user password 
					System.out.println("Now please enter the password you will want on your account:");
					String Password = in.nextLine();
					System.out.println("What is your starting balance?");
					
				try {
					 double balance = in.nextDouble();
					UserStorage info = new UserStorage(Username, Password, balance);
					dao.Register(info);	
					System.out.println();
				   return new BankMenu();
				} catch (InputMismatchException e)  {	
                  log.warn("invalid deposit. Please try again!");
	           
			}
				return new UserRegister();   
			}
}
						 			 