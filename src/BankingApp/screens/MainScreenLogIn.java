package BankingApp.screens;

import BankingApp.beans.User;
import BankingApp.factories.ScreenFactory;

import java.util.Scanner;

/**
 * Functionality: Manages the main menu displayed if the user is logged in.
 */
public class MainScreenLogIn implements Screen {
    private User currentUser;

    public MainScreenLogIn(User u) {
        this.currentUser = u;
    }

    @Override
    public void prompt() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Current balance is: $%.2f. Withdraw, deposit, view transaction history, or log out? (W/D/T/L) << ", currentUser.getBalance());
        String cmd = in.nextLine();
        switch (cmd){
            case "W":
                ScreenFactory.getScreenFactory().setCurrentScreen("withdraw", currentUser);
                break;
            case "D":
                ScreenFactory.getScreenFactory().setCurrentScreen("deposit", currentUser);
                break;
            case "T":
                ScreenFactory.getScreenFactory().setCurrentScreen("viewTransactions", currentUser);
                break;
            case "L":
                ScreenFactory.getScreenFactory().setCurrentScreen("logout");
                break;
            case "exit":
                ScreenFactory.getScreenFactory().setCurrentScreen("exit");
                break;
            default:
                System.out.println("Invalid command.");
                break;
        }
    }
}
