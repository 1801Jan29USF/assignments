package com.revature.bankapp;

import com.revature.screens.InitialScreen;
import com.revature.screens.Screen;

/**
 * Main method is a one liner!
 * @author Rick
 *
 */
public class Banker {
	public static void main(String[] args) {

		Screen currentScreen = new InitialScreen();
		while (true) {
			currentScreen = currentScreen.prompt();
		}

	}

}
