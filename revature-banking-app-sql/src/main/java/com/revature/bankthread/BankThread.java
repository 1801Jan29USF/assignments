package com.revature.bankthread;

import com.revature.bankinglauncher.BankingLauncher;
/*
 * Oracle bank thread. 
 */
public class BankThread {
	public static void main(String[] args) {
		Thread t = new Thread(new BankingLauncher());
		t.start();
	}
}
