package BankingApp.screens;

/**
 * Functionality: Exists purely for the while loop to close upon. The prompt function should never run.
 */
public class ShutdownScreen implements Screen {
    @Override
    public Screen prompt() {
        return null;
    }//never actually returns null
}
