package BankingApp.util;

import BankingApp.beans.Bank;

import java.io.*;

/**
 * Functionality: Utility function to serialize bank objects for retrieval.
 */
public class BankSerializer {
    public void writeBankFile(Object object, String filePath){
        try (FileOutputStream file = new FileOutputStream(filePath)) {
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(object);
            out.close();
            file.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public Object readBankFile(String filePath){
        try(FileInputStream file = new FileInputStream(filePath)) {
            ObjectInputStream in = new ObjectInputStream(file);

            Bank bank = (Bank)in.readObject();
            in.close();
            file.close();
            return bank;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
