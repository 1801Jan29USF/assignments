package com.revature.bankapp;

import java.util.ArrayList;

import com.revature.dao.BankUserDAO;

/**
 * There is only one bank using the singleton design pattern. The bank holds the
 * list of bank users and knows how to check for username and password.
 * 
 * @author Rick
 *
 */
public class Bank {
	private static Bank b = new Bank();
	BankUserDAO bd = new BankUserDAO();
	private ArrayList<BankUser> aL = bd.getUserList();
	private int index;

	private Bank() {

	}

	public static Bank getSingleton() {
		return b;
	}

	public ArrayList<BankUser> getList() {
		return this.aL;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return this.index;
	}

	/*
	 * To get a specific user
	 */
	public BankUser getUser() {
		return this.aL.get(this.index);
	}

	/*
	 * Checks user-name and saves the current index.
	 */
	public boolean checkUsername(String input) {
		for (BankUser bUser : aL) {
			if (bUser.getUsername().equals(input)) {
				this.index = aL.indexOf(bUser);
				return true;
			}
		}
		return false;
	}

	/*
	 * Checks for matching password.
	 */
	public boolean checkPassword(String input) {
		for (BankUser bUser : aL) {
			if (bUser.getPassword().equals(input))
				return true;

		}
		return false;
	}

}
