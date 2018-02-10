package com.revature.bankinglauncher;

import com.revature.screens.MainMenu;
import com.revature.screens.Screen;


public class BankingLauncher implements Runnable {
		public void run() {
			System.out.println("Welcome to Bank of Revature!\n");
			Screen currentScreen = new MainMenu();
			while (true) {
				currentScreen = currentScreen.prompt();
			}			
		}
		
	}

