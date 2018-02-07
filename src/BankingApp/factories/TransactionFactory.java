package BankingApp.factories;

import BankingApp.beans.Transaction;

/**
 * Functionality: Simple factory for transactions, used mainly to have unique ids for all transactions
 */
public class TransactionFactory {
    private static int id = 1;

    public static Transaction getTransaction(double amt, boolean isWithdrawal, String datetime) {
        return new Transaction(id++, amt, isWithdrawal, datetime);
    }
}
