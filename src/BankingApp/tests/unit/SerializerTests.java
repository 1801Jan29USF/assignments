package BankingApp.tests.unit;

import BankingApp.beans.Bank;
import BankingApp.util.BankSerializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Functionality:
 */
public class SerializerTests {
    private Bank b;
    private String filepath = "src/BankingApp/tests/unit/test.txt";
    //private File f;
    @Before
    public void init(){
        //f = new File("src/BankingApp/tests/unit/test.txt");
        b = Bank.getBank();
        BankSerializer.setFilepath(filepath);
    }
    @Test
    public void checkSerialization(){
        b.addUser("test2", "test");
        BankSerializer.getBankSerializer().writeBankFile(b, filepath);
        Assert.assertTrue(new File(filepath).exists());
    }
    @Test
    public void checkDeserialization(){
        Bank b = (Bank)BankSerializer.getBankSerializer().readBankFile(filepath);
        Assert.assertNotNull(b.login("test2", "test"));
    }
}
