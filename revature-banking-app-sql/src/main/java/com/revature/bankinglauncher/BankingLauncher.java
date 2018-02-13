package com.revature.bankinglauncher;

import com.revature.screens.MainMenu;
import com.revature.screens.Screen;
import com.revature.bankinglauncher.PrintOracle;

/*
 * Oracle Banking Launcher implements the Runnable Interface 
 * and overrides the run function to begin a thread.
 */


public class BankingLauncher implements Runnable {

	public void run() {
		//print the banking screen
		PrintOracle p = new PrintOracle();
		p.printTitle();
		Screen currentScreen = new MainMenu();
		while (true) {
			currentScreen = currentScreen.prompt();
		}
	}

}
