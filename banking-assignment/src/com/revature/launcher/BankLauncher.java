package com.revature.launcher;

import com.revature.screens.MainMenu;
import com.revature.screens.Screen;

public class BankLauncher {

	public static void main(String[] args) {
		Screen currentScreen = new MainMenu();
		while (true) {
			currentScreen = currentScreen.prompt();
		}
	}
}