package BankingApp.screens;

import BankingApp.factories.ScreenFactory;

import java.util.Scanner;

/**
 * Functionality: Manages the main screen displayed if the user is not currently logged in.
 */
public class MainScreenNoLogIn implements Screen {

    @Override
    public void prompt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Log in or Register? (L/R) << ");
        String cmd = in.nextLine();
        switch (cmd){
            case "L":
                ScreenFactory.getScreenFactory().setCurrentScreen("login");
                break;
            case "R":
                ScreenFactory.getScreenFactory().setCurrentScreen("register");
                break;
            case "exit":
                ScreenFactory.getScreenFactory().setCurrentScreen("exit");
                break;
            default:
                System.out.println("Command not recognized.");
                break;
        }
    }
}
