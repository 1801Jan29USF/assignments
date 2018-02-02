package BankingApp.screens;

import BankingApp.beans.Bank;
import BankingApp.factories.ScreenFactory;
import BankingApp.util.BankSerializer;

/**
 * Functionality: Manages the closing of the application, serializing the bank before shutting down.
 */
public class ExitScreen implements Screen {

    @Override
    public void prompt() {
        if(Bank.getBank() != null){
            BankSerializer.getBankSerializer().writeBankFile(Bank.getBank(), "src/BankingApp/banks/Bank.bnk");
        }
        ScreenFactory.getScreenFactory().setCurrentScreen("shutdown");
    }
}
