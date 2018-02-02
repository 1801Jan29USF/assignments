package BankingApp.factories;

import BankingApp.beans.User;
import BankingApp.screens.*;

/**
 * Functionality: A singleton factory for Screen objects
 */
public class ScreenFactory {
    private static ScreenFactory ScreenFactory = new ScreenFactory();
    private static Screen currentScreen = new StartupScreen();
    private ScreenFactory(){
        
    }

    public static ScreenFactory getScreenFactory() {
        return ScreenFactory;
    }
    
    public void setCurrentScreen(String type){
        switch(type){
            case "exit":
                currentScreen = new ExitScreen();
                break;
            case "login":
                currentScreen = new LoginScreen();
                break;
            case "logout":
                currentScreen = new LogoutScreen();
                break;
            case "mainNoLogIn":
                currentScreen = new MainScreenNoLogIn();
                break;
            case "register":
                currentScreen = new RegisterScreen();
                break;
            case "shutdown":
                currentScreen = new ShutdownScreen();
                break;
            default:
                System.out.println("UHOH");
                break;
        }
    }
    public void setCurrentScreen(String type, User user){
        switch(type){
            case "deposit":
                currentScreen = new DepositScreen(user);
                break;
            case "mainLogIn":
                currentScreen = new MainScreenLogIn(user);
                break;
            case "viewTransactions":
                currentScreen = new ViewTransactionHistoryScreen(user);
                break;
            case "withdraw":
                currentScreen = new WithdrawScreen(user);
                break;
            default:
                System.out.println("UHOH");
                break;
        }
    }

    public static Screen getCurrentScreen() {
        return currentScreen;
    }
}
