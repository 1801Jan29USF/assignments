package BankingApp.screens;

import BankingApp.factories.ScreenFactory;

/**
 * Functionality: Manages the log out function.
 */
public class LogoutScreen implements Screen {

    @Override
    public void prompt() {
        ScreenFactory.getScreenFactory().setCurrentScreen("mainNoLogIn");
    }
}
