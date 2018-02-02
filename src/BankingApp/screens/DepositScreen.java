package BankingApp.screens;

import BankingApp.beans.Bank;
import BankingApp.beans.User;

import java.util.Scanner;

/**
 * Functionality: Manages the screen displaying the deposit function.
 */
public class DepositScreen implements Screen {
    private User currentUser;

    DepositScreen(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public Screen prompt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Deposit amount << ");
        String amt = in.nextLine();
        if(Bank.getBank().deposit(currentUser, amt)){
            System.out.println("Deposit successful!");
        }
        else{
            System.out.println("Deposit failed.");
        }
        return new MainScreenLogIn(currentUser);
    }
}
