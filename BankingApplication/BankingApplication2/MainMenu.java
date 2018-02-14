package com.revature.BankingApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;


public class MainMenu implements ScreenBank {  
		Scanner input = new Scanner(System.in);
		DatabaseDAO dao = new DatabaseDAO();
		private UserStorage User;
		private Logger log = Logger.getRootLogger();


		public MainMenu(UserStorage User) {
			// TODO Auto-generated constructor stub
		    this.User = User;
		}


		@Override
		public ScreenBank prompt() {
			// TODO Auto-generated method stub
		  System.out.printf("Welcome " + this.User.getUsername() + "! What would you like to do? Type B for balance W for withdraw D for deposit T for transaction history or E to logout");
		  String u = input.nextLine();
		  switch(u) {
		  
		  case "B":
			System.out.println("Your current balance is: " + this.User.getBalance());
			  break;
			  
		  case "W":
			  System.out.println("How much do you want to withdraw? " + "Current balance is " + this.User.getBalance());
			try { 
			  double w = input.nextDouble();
			  if(this.User.getBalance() >= w && w >= 0) {
		         this.User.setBalance(this.User.getBalance() - w);
		         
	   			System.out.println("Your bank total is now: " +this.User.getBalance()); 
	   			dao.Update(User);
		        } else { System.out.println("Sorry, you have insufficient funds available " + this.User.getBalance());}  
			  
			} catch (InputMismatchException e) {
				log.warn("Sorry! invalid input");
			}
			  
			  
			 break;
			 
		  case "D":
			   System.out.println("How much do you want to deposit? Your current balance is " + this.User.getBalance());
			   try {
				   Double deposit = input.nextDouble();
			      this.User.setBalance(User.getBalance() + deposit);
				   log.trace("updating balance");
			   } catch (InputMismatchException e) {
				  log.warn("Sorry! invalid deposit");
			  
		       dao.Update(User);
			   }
	        break;
	        
		  case "T":	
			  dao.getTransaction(User.getUsername());
			  
			  break;
		  case "E":
			  System.out.println("Thank you come again! " + this.User.getUsername());
			  System.out.println();
			  
			  return new BankMenu();
		      
			  
		  }
		return new MainMenu(User);
		}

	}