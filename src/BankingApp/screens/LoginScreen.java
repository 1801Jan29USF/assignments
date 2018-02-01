package BankingApp.screens;

import BankingApp.beans.Bank;
import BankingApp.beans.User;

import java.util.Scanner;

/**
 * Functionality: Manages the log in screen.
 */
public class LoginScreen implements Screen {
    private Bank bank;

    LoginScreen(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Screen prompt() {
        String user, pwd;
        Scanner in = new Scanner(System.in);
        System.out.print("Username << ");
        user = in.nextLine();
        System.out.print("Password << ");
        pwd = in.nextLine();
        User u = bank.login(user, pwd);
        if(u != null){
            System.out.println("Log in successful!");
            return new MainScreenLogIn(u, bank);
        }
        else{
            System.out.println("Invalid log in attempt.");
            return new MainScreenNoLogIn(bank);
        }
    }
}
