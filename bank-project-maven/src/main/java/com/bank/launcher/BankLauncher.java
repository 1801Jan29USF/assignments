package com.bank.launcher;
import com.bank.beans.AuthUser;
import com.bank.dao.BankDAOJDBC;
import com.bank.dao.bankDAO;
import com.bank.screens.*;
import java.util.*;


/**
 * @author Brandon
 * Launcher for the bank
 *
 */
public class BankLauncher {
	public static void main(String[] args) {
	//UserSerializer us = UserSerializer.getUserSerializer();
		
		bankDAO bdao = BankDAOJDBC.getBdao();
		
//		bdao.deposit(29, 100);
//		bdao.withdraw(29, 100);
//		bdao.getUserBal(29);

		Screen currentScreen = new LoginScreen();
		while (true) {
			currentScreen.prompt();
		}
	}

}
