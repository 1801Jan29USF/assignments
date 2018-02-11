package com.bank.launcher;
import com.bank.beans.AuthUser;
import com.bank.screens.*;
import com.bank.util.UserSerializer;
import java.util.*;


/**
 * @author Brandon
 * Launcher for the bank, imports singleton userserializer from getUserSerializer() method.
 *
 */
public class BankLauncher {
	public static void main(String[] args) {
	UserSerializer us = UserSerializer.getUserSerializer();

		Screen currentScreen = new LoginScreen();
		while (true) {
			currentScreen.prompt();
		}
	}

}
