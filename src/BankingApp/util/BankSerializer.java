package BankingApp.util;

import BankingApp.beans.Bank;

import java.io.*;

/**
 * Functionality: Utility singleton function to serialize bank objects for retrieval.
 */
public class BankSerializer {
    private static String filepath = "src/BankingApp/banks/Bank.bnk";
    private static BankSerializer bankSerializer = new BankSerializer(filepath);

    private BankSerializer(String strFilePath){
        filepath = strFilePath;
        File file = new File(filepath);
        try {
            if(!file.createNewFile()) {
                Bank.setBank((Bank)readBankFile(filepath));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void setFilepath(String filepath) {
        BankSerializer.filepath = filepath;
        bankSerializer = new BankSerializer(filepath);
    }

    public static void doNothing(){}

    public static BankSerializer getBankSerializer() {
        return bankSerializer;
    }

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
