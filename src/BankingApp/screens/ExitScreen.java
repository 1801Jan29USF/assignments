package BankingApp.screens;

import BankingApp.beans.Bank;
import BankingApp.util.BankSerializer;

import java.util.Scanner;

/**
 * Functionality: Manages the closing of the application, serializing the bank before shutting down.
 */
public class ExitScreen implements Screen {
    private Bank bank;

    ExitScreen(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Screen prompt() {
        if(bank != null){
            BankSerializer bs = new BankSerializer();
            bs.writeBankFile(bank, "src/BankingApp/banks/Bank.bnk");
        }
        new Scanner(System.in).close();
        return new ShutdownScreen();
    }
}
