package com.revature.BankingApplication;

public class BankLauncher {
	public static void main(String[] args) {
		ScreenBank currentScreen = new BankMenu();
		while (true) {
			currentScreen = currentScreen.prompt();
		}
}
}