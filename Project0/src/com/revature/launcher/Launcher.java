package com.revature.launcher;

import com.revature.screens.LoginScreen;
import com.revature.screens.Screen;

public class Launcher {
	public static void main(String[] args) {
		Screen currentScreen = new LoginScreen();
		while (true) {
			currentScreen = currentScreen.prompt();
		}
	}
}
