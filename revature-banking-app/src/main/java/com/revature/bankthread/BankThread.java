package com.revature.bankthread;

import com.revature.bankinglauncher.BankingLauncher;

public class BankThread {

	public static void main(String[] args) {
		 Thread t = new Thread(new BankingLauncher());
		 t.start();
	}
}
