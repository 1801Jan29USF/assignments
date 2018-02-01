package BankingApp.screens;

import BankingApp.beans.Bank;
import BankingApp.beans.User;

import java.util.Scanner;

/**
 * Functionality: Manages the withdrawal functionality.
 */
public class WithdrawScreen implements Screen {
    private User currentUser;
    private Bank bank;

    WithdrawScreen(User currentUser, Bank bank) {
        this.currentUser = currentUser;
        this.bank = bank;
    }

    @Override
    public Screen prompt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Withdrawal amount << ");
        String amt = in.nextLine();
        if(bank.withdraw(currentUser, amt)){
            System.out.println("Withdrawal successful!");
        }
        else{
            System.out.println("Withdrawal failed.");
        }
        return new MainScreenLogIn(currentUser, bank);
    }
}
