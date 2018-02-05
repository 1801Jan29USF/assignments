package BankingApp.tests.unit;

import BankingApp.beans.Bank;
import BankingApp.beans.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Functionality:
 */
public class BankTests {
    private Bank b;
    private User u1;
    @Before
    public void init(){
        b = Bank.getBank();
        u1 = b.login("test", "test");
        Assert.assertNotNull(u1);
    }
    @Test
    public void checkAddUser(){
        b.addUser("test2", "test");
        Assert.assertNotNull(b.login("test2", "test"));
    }
    @Test
    public void checkOverDraw(){
        Assert.assertFalse(b.withdraw(u1, 10000000));
    }
    @Test
    public void checkDeposit(){
        double pastBalance = u1.getBalance();
        Assert.assertTrue(b.deposit(u1, 3));
        Assert.assertTrue(u1.getBalance() - pastBalance == (double)3);
    }
    @Test
    public void checkWithdraw(){
        double pastBalance = u1.getBalance();
        Assert.assertTrue(b.deposit(u1, 10));
        Assert.assertTrue(b.withdraw(u1, 2));
        Assert.assertTrue(u1.getBalance() - pastBalance == (double)10-2);
    }
    @Test
    public void checkTransactionHistory(){
        b.deposit(u1, 10);
        Assert.assertTrue(u1.getTransactionHistory().size() > 0);
    }
}
