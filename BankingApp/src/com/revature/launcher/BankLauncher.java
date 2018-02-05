package com.revature.launcher;


import com.revature.screens.Screen;
import com.revature.screens.StartScreen;

/**
 * Launches the application. Prompts a new StartScreen, thus beginning the
 * application.
 * 
 * @author poblo
 *
 */
public class BankLauncher {

	public static void main(String[] args) {
		Screen currentScreen = new StartScreen();
		while (true) {
			currentScreen = currentScreen.prompt();
		}
	}

}
