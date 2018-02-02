package BankingApp.screens;

/**
 * Functionality: Manages the log out function.
 */
public class LogoutScreen implements Screen {

    @Override
    public Screen prompt() {
        return new MainScreenNoLogIn();
    }
}
