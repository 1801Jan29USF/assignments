package BankingApp.screens;

import BankingApp.beans.Bank;
import BankingApp.beans.User;
/**
 * Functionality: Manages the screen which displays the transaction history of the logged in user.
 */
public class ViewTransactionHistoryScreen implements Screen {
    private User currentUser;
    private Bank bank;

    ViewTransactionHistoryScreen(User currentUser, Bank bank) {
        this.currentUser = currentUser;
        this.bank = bank;
    }

    @Override
    public Screen prompt() {
        System.out.println("Transaction History:");
        bank.printTransactionHistory(currentUser);
        return new MainScreenLogIn(currentUser, bank);
    }
}
