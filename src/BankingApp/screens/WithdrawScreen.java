package BankingApp.screens;

import BankingApp.beans.Bank;
import BankingApp.beans.User;

import java.util.Scanner;

/**
 * Functionality: Manages the withdrawal functionality.
 */
public class WithdrawScreen implements Screen {
    private User currentUser;

    WithdrawScreen(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public Screen prompt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Withdrawal amount << ");
        String amt = in.nextLine();
        if(Bank.getBank().withdraw(currentUser, amt)){
            System.out.println("Withdrawal successful!");
        }
        else{
            System.out.println("Withdrawal failed.");
        }
        return new MainScreenLogIn(currentUser);
    }
}
