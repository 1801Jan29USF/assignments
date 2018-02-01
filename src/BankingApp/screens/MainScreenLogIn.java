package BankingApp.screens;

import BankingApp.beans.Bank;
import BankingApp.beans.User;

import java.util.Scanner;

/**
 * Functionality: Manages the main menu displayed if the user is logged in.
 */
public class MainScreenLogIn implements Screen {
    private User currentUser;
    private Bank bank;

    MainScreenLogIn(User u, Bank bank) {
        this.currentUser = u;
        this.bank = bank;
    }

    @Override
    public Screen prompt() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Current balance is: $%.2f. Withdraw, deposit, view transaction history, or log out? (W/D/T/L) << ", currentUser.getBalance());
        String cmd = in.nextLine();
        switch (cmd){
            case "W":
                return new WithdrawScreen(currentUser, bank);
            case "D":
                return new DepositScreen(currentUser, bank);
            case "T":
                return new ViewTransactionHistoryScreen(currentUser, bank);
            case "L":
                return new LogoutScreen(bank);
            case "exit":
                return new ExitScreen(bank);
            default:
                System.out.println("Invalid command.");
                return this;
        }
    }
}
