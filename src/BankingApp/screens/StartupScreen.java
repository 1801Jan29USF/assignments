package BankingApp.screens;

import BankingApp.factories.ScreenFactory;

/**
 * Functionality:
 */
public class StartupScreen implements Screen {
    @Override
    public void prompt() {
        System.out.println("Welcome to the National Bank Online Interface. Type 'exit' at any point to exit the system.");
        ScreenFactory.getScreenFactory().setCurrentScreen("mainNoLogIn");
    }
}
