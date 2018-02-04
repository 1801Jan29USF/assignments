package com.revature.bankinglauncher;

import com.revature.beans.Bank;
import com.revature.screens.MainMenu;
import com.revature.screens.Screen;

public class BankingLauncher {
	public static void main(String[] args) {

		// Singleton bank instance
		Bank bank = Bank.getBank();
		System.out.println("Welcome to Bank of Revature!\n");
		Screen currentScreen = new MainMenu(bank);
		while (true) {
			currentScreen = currentScreen.prompt(bank);
		}
	}
}
