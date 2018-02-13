package com.revature.launcher;

import com.revature.bank.Bank;
import com.revature.beans.User;
import com.revature.interfaces.Screen;
import com.revature.screens.Login;
/**
 * launches the program
 *  since add user functionality has not been implemented, new users can be added explicitly here
 * @author Matt
 *
 */
public class Launcher {
	
	public static void main(String[] args) {
		
//		Bank bank = Bank.getBank();
//		bank.addUser(new User("matt", "pass", 157.65));
//		bank.addUser(new User("rick", "talk", 27));
//		bank.addUser(new User("adrian", "wizard", 9000.01));
//		bank.addUser(new User("blake", "coolTrainer", 420));
//		bank.addUser(new User("steve", "wonder", 69));
		
		Screen nextScreen = new Login();
		
		while(true) {
			nextScreen = nextScreen.prompt();
		}
	}
}
