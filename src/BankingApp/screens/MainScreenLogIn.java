package BankingApp.screens;

import BankingApp.factories.ScreenFactory;

import java.util.Scanner;

/**
 * Functionality: Manages the main menu displayed if the user is logged in.
 */
public class MainScreenLogIn implements Screen {

    @Override
    public void prompt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Your options are: View balance, view transaction history, withdraw, deposit, or log out. (B/W/D/T/L) << ");
        String cmd = in.nextLine();
        switch (cmd){
            case "B":
                ScreenFactory.getScreenFactory().setCurrentScreen("viewBalance");
                break;
            case "W":
                ScreenFactory.getScreenFactory().setCurrentScreen("withdraw");
                break;
            case "D":
                ScreenFactory.getScreenFactory().setCurrentScreen("deposit");
                break;
            case "T":
                ScreenFactory.getScreenFactory().setCurrentScreen("viewTransactions");
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
