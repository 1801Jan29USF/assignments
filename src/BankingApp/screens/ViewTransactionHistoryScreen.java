package BankingApp.screens;

import BankingApp.beans.Bank;
import BankingApp.beans.User;
import BankingApp.factories.ScreenFactory;

/**
 * Functionality: Manages the screen which displays the transaction history of the logged in user.
 */
public class ViewTransactionHistoryScreen implements Screen {
    private User currentUser;

    public ViewTransactionHistoryScreen(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public void prompt() {
        System.out.println("Transaction History:");
        Bank.getBank().printTransactionHistory(currentUser);
        ScreenFactory.getScreenFactory().setCurrentScreen("mainLogIn", currentUser);
    }
}
