package BankingApp.screens;

import BankingApp.beans.Bank;

import java.util.Scanner;

/**
 * Functionality: Manages the main screen displayed if the user is not currently logged in.
 */
public class MainScreenNoLogIn implements Screen {
    private Bank bank;

    public MainScreenNoLogIn(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Screen prompt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Log in or Register? (L/R) << ");
        String cmd = in.nextLine();
        switch (cmd){
            case "L":
               return new LoginScreen(bank);
            case "R":
                return new RegisterScreen(bank);
            case "exit":
                return new ExitScreen(bank);
            default:
                System.out.println("Command not recognized.");
                return this;
        }
    }
}
