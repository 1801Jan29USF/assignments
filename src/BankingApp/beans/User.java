package BankingApp.beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Functionality: A bean describing a user of a bank with a username, password, account balance, and transaction history
 */
public class User implements Serializable {
    static final long serialVersionUID = 42L;
    private final String username;
    private final String password;
    private ArrayList<Transaction> transactionHistory;
    private double balance;

    User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void addToTransactionHistory(Transaction t) {
        this.transactionHistory.add(t);
    }
}
