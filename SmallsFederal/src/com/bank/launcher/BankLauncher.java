package com.bank.launcher;

import com.bank.beans.User;
import com.bank.screens.MainMenu;
import com.bank.screens.Screen;

public class BankLauncher {

	public static void main(String[] args) {
		
		Screen currentScreen = new MainMenu();
		
		while (true) {
			currentScreen = currentScreen.prompt(); 
		}
	}
}
