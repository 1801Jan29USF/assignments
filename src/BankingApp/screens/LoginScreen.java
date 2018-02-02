package BankingApp.screens;

import BankingApp.beans.Bank;
import BankingApp.beans.User;
import BankingApp.factories.ScreenFactory;

import java.util.Scanner;

/**
 * Functionality: Manages the log in screen.
 */
public class LoginScreen implements Screen {

    @Override
    public void prompt() {
        String user, pwd;
        Scanner in = new Scanner(System.in);
        System.out.print("Username << ");
        user = in.nextLine();
        System.out.print("Password << ");
        pwd = in.nextLine();
        User currentUser = Bank.getBank().login(user, pwd);
        if(currentUser != null){
            System.out.println("Log in successful!");
            ScreenFactory.getScreenFactory().setCurrentScreen("mainLogIn", currentUser);
        }
        else{
            System.out.println("Invalid log in attempt.");
            ScreenFactory.getScreenFactory().setCurrentScreen("mainNoLogIn");
        }
    }
}
