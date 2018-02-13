package com.revature.launcher;

import com.revature.screens.BankMenu;
import com.revature.screens.Screen;

public class BankLauncher {


	public static void main(String[] args) {
		Screen currentScreen = new BankMenu();
		while (true) {
			currentScreen = currentScreen.prompt();
		}
	}
}