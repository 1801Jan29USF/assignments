package BankingApp.screens;

import BankingApp.beans.Bank;
/**
 * Functionality: Manages the log out function.
 */
public class LogoutScreen implements Screen {
    private Bank bank;

    LogoutScreen(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Screen prompt() {
        return new MainScreenNoLogIn(bank);
    }
}
