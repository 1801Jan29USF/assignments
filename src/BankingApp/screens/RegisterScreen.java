package BankingApp.screens;

import BankingApp.beans.Bank;

import java.util.Scanner;

/**
 * Functionality: Manages the account registration screen.
 */
public class RegisterScreen implements Screen {

    @Override
    public Screen prompt() {
        String user, pwd;
        Scanner in = new Scanner(System.in);
        System.out.print("Username << ");
        user = in.nextLine();
        System.out.print("Password << ");
        pwd = in.nextLine();
        if(Bank.getBank().register(user, pwd)){
            System.out.println("User registered! Try logging in now.");
        }
        else{
            System.out.println("User already exists.");
        }
        return new MainScreenNoLogIn();
    }
}
