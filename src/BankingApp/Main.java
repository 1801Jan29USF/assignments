package BankingApp;


import BankingApp.beans.Bank;
import BankingApp.screens.MainScreenNoLogIn;
import BankingApp.screens.Screen;
import BankingApp.screens.ShutdownScreen;
import BankingApp.util.BankSerializer;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final BankSerializer bs = new BankSerializer();
    public static void main(String[] args) {
        Bank bank = new Bank();
        File file = new File("src/BankingApp/banks/Bank.bnk");
        try {
            if(!file.createNewFile()) {
                bank = (Bank)bs.readBankFile("src/BankingApp/banks/Bank.bnk");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Screen currentScreen = new MainScreenNoLogIn(bank);
        System.out.println("Welcome to the National Bank Online Interface. Type 'exit' at any point to exit the system.");
        while(!currentScreen.getClass().equals(ShutdownScreen.class)){
            currentScreen = currentScreen.prompt();
        }
        System.out.println("Shutting down system... Have a nice day.");
    }
}
