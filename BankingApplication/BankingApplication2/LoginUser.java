package com.revature.BankingApplication;


import java.util.Scanner;


public class LoginUser extends DatabaseDAO implements ScreenBank {
		private Scanner in = new Scanner(System.in);	
		
		
		@Override
		public ScreenBank prompt() {		   
			 System.out.println("Please enter your username so we can locate your profile:");
			 String Username = in.nextLine();
	         System.out.println("Please enter your password: ");
		     String Password = in.nextLine();
		 
		     if(get(Username, Password) == null) {
		      System.out.println("Invalid Username or Password");
		      return new BankMenu();
		     } else {
		     return new MainMenu(get(Username,Password));
		     }
		}
}    
		     
		     
		     
		     
		     
		     
		     
		
	         
		     
		     
		     
		 
	

	

