package BankingApp.beans;

import java.io.Serializable;

/**
 * Functionality: A bean which describes a transaction with an id, amount, whether it was a withdrawal, and datetime of transaction.
 */
public class Transaction implements Serializable {
    static final long serialVersionUID = 42L;
    private int id;
    private final double amount;
    private final boolean withdrawal;
    private final String datetime;

    public Transaction(int id, double amount, boolean withdrawal, String datetime) {
        this.id = id;
        this.amount = amount;
        this.withdrawal = withdrawal;
        this.datetime = datetime;
    }

    public String toString(){

        return String.format("ID: %d, %s: $%.2f, Date: %s",
                id,
                (withdrawal ? "Withdrawal": "Deposit"),
                amount,
                datetime);
    }
}
