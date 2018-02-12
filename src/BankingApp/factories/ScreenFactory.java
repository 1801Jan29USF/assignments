package BankingApp.factories;

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
                currentScreen = new MainScreenNoLogIn();
                break;
            case "mainNoLogIn":
                currentScreen = new MainScreenNoLogIn();
                break;
            case "register":
                currentScreen = new RegisterScreen();
                break;
            case "deposit":
                currentScreen = new DepositScreen();
                break;
            case "mainLogIn":
                currentScreen = new MainScreenLogIn();
                break;
            case "viewTransactions":
                currentScreen = new ViewTransactionHistoryScreen();
                break;
            case "viewBalance":
                currentScreen = new ViewBalanceScreen();
                break;
            case "withdraw":
                currentScreen = new WithdrawScreen();
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
