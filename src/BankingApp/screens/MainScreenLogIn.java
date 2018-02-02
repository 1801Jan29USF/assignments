package BankingApp.screens;

import BankingApp.beans.User;

import java.util.Scanner;

/**
 * Functionality: Manages the main menu displayed if the user is logged in.
 */
public class MainScreenLogIn implements Screen {
    private User currentUser;

    MainScreenLogIn(User u) {
        this.currentUser = u;
    }

    @Override
    public Screen prompt() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Current balance is: $%.2f. Withdraw, deposit, view transaction history, or log out? (W/D/T/L) << ", currentUser.getBalance());
        String cmd = in.nextLine();
        switch (cmd){
            case "W":
                return new WithdrawScreen(currentUser);
            case "D":
                return new DepositScreen(currentUser);
            case "T":
                return new ViewTransactionHistoryScreen(currentUser);
            case "L":
                return new LogoutScreen();
            case "exit":
                return new ExitScreen();
            default:
                System.out.println("Invalid command.");
                return this;
        }
    }
}
