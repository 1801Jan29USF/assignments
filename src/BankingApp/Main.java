package BankingApp;


import BankingApp.factories.ScreenFactory;
import BankingApp.screens.ExitScreen;

public class Main {
    public static void main(String[] args) {
        while(!ScreenFactory.getCurrentScreen().getClass().equals(ExitScreen.class)){
            ScreenFactory.getCurrentScreen().prompt();
        }
        System.out.println("Shutting down system... Have a nice day.");
    }
}
