package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Java bean for use in Banking app. Defines a user with a username, password
 * and bank balance. Also stores the name of the file where the user object
 * should be serialized and an ArrayList of Transaction objects for use in
 * displaying the user's transaction history. Finally, this class contains
 * methods for printing and managing the user's transaction history
 * 
 * @author poblo
 *
 */
public class BankUser implements Serializable {

	private static final long serialVersionUID = -4523290424001706725L;
	String username;
	String password;
	Double balance;
	String file;
	ArrayList<Transaction> history;

	public BankUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.balance = 0.0;
		this.file = "src/UserData/" + username + ".txt";
		this.history = new ArrayList<Transaction>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankUser other = (BankUser) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return balance;
	}

	public ArrayList<Transaction> getHistory() {
		return history;
	}

	public void setHistory(ArrayList<Transaction> history) {
		this.history = history;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public void deposit(Double amount) {
		this.balance += amount;
	}

	// Withdraws from the user's account, throwing an exception if the requested
	// amount
	// is greater than the user's balance
	public void withdraw(Double amount) throws Exception {
		if (amount > this.balance) {
			Exception e = new Exception();
			throw e;
		} else {
			this.balance -= amount;
			// this.addTransaction("Withdrew", amount);
		}
	}

	// Quickly withdraws without throwing an exception. Does nothing if the amount
	// is greater than the balance.
	public void safeWithdraw(Double amount) {
		if (amount <= balance) {
			this.balance -= amount;
			// this.addTransaction("Withdrew", amount);
		}
	}

	// Creates a new Transaction and adds it to the user's history
	public void addTransaction(String action, Double amount) {
		Date currentDate = Calendar.getInstance().getTime();
		Transaction newT = new Transaction(action, amount, currentDate);
		history.add(newT);
	}

	// Prints the user's transaction history to the console
	public void printTransactionHistory() {
		// If the user has yet to make a transaction, prints a message to the console
		if (this.history.size() == 0) {
			System.out.println("You have not yet made any transactions");
		} else {
			for (int i = 0; i < this.history.size(); i++) {
				Transaction t = this.history.get(i);
				System.out.println("On " + t.getDateAndTime() + ", " + this.username + " " + t.getAction() + " $"
						+ t.getAmount() + ".");
			}
		}
	}

	// Removes the last Transaction from the user's history
	public void cancelTransaction() {
		this.history.remove(this.history.size() - 1);
	}
}
