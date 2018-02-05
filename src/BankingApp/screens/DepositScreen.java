package BankingApp.screens;

import BankingApp.beans.Bank;
import BankingApp.beans.User;
import BankingApp.factories.ScreenFactory;

import java.util.Scanner;

/**
 * Functionality: Manages the screen displaying the deposit function.
 */
public class DepositScreen implements Screen {
    private User currentUser;

    public DepositScreen(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public void prompt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Deposit amount << ");
        String amt = in.nextLine();
        if(Bank.getBank().deposit(currentUser, Double.parseDouble(amt))){
            System.out.println("Deposit successful!");
        }
        else{
            System.out.println("Deposit failed.");
        }
        ScreenFactory.getScreenFactory().setCurrentScreen("mainLogIn", currentUser);
    }
}
