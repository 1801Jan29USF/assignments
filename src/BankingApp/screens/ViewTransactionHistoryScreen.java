package BankingApp.screens;

import BankingApp.beans.Bank;
import BankingApp.beans.User;
/**
 * Functionality: Manages the screen which displays the transaction history of the logged in user.
 */
public class ViewTransactionHistoryScreen implements Screen {
    private User currentUser;

    ViewTransactionHistoryScreen(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public Screen prompt() {
        System.out.println("Transaction History:");
        Bank.getBank().printTransactionHistory(currentUser);
        return new MainScreenLogIn(currentUser);
    }
}
