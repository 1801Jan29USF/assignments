package com.revature.bank.launcher;

import com.revature.bank.screens.MainMenu;
import com.revature.bank.screens.Screen;

/*
 * Launches the application, and start the user at the Main menu scree.
 */
public class BankLauncher {

	public static void main(String[] args) {

		
		Screen currentScreen = new MainMenu();
		while (true) {
			currentScreen = currentScreen.prompt();
		}
		

	}

}
