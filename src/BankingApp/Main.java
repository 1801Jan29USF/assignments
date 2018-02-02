package BankingApp;


import BankingApp.factories.ScreenFactory;
import BankingApp.screens.ShutdownScreen;
import BankingApp.util.BankSerializer;

public class Main {
    public static void main(String[] args) {
        BankSerializer.doNothing();
        while(!ScreenFactory.getCurrentScreen().getClass().equals(ShutdownScreen.class)){
            ScreenFactory.getCurrentScreen().prompt();
        }
        System.out.println("Shutting down system... Have a nice day.");
    }
}
