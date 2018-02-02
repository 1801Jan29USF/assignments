package BankingApp.screens;

import java.util.Scanner;

/**
 * Functionality: Manages the main screen displayed if the user is not currently logged in.
 */
public class MainScreenNoLogIn implements Screen {

    @Override
    public Screen prompt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Log in or Register? (L/R) << ");
        String cmd = in.nextLine();
        switch (cmd){
            case "L":
               return new LoginScreen();
            case "R":
                return new RegisterScreen();
            case "exit":
                return new ExitScreen();
            default:
                System.out.println("Command not recognized.");
                return this;
        }
    }
}
