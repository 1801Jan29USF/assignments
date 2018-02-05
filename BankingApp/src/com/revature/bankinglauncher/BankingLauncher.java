package com.revature.bankinglauncher;

import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.beans.Bank;
import com.revature.screens.MainMenu;
import com.revature.screens.Screen;

public class BankingLauncher {
	public static void main(String[] args) {
		
		ArrayList<Account> accounts = new ArrayList<>(0);
		
		//bank instance
		Bank bank = new Bank(accounts);
		
		Screen currentScreen = new MainMenu(bank);
		while (true) {
			currentScreen = currentScreen.prompt();
		}
	}
}
