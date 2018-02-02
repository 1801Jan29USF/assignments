package BankingApp.beans;

import BankingApp.factories.TransactionFactory;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Functionality: A bean describing a bank with a list of users.
 */
public class Bank implements Serializable {
    private static Bank bank = new Bank();
    static final long serialVersionUID = 42L;
    private ArrayList<User> userList;

    private Bank(){
        userList = new ArrayList<>();
        userList.add(new User("test", "test"));
    }

    public static Bank getBank(){
        return bank;
    }

    public static void setBank(Bank b){
        bank = b;
    }

    public User login(String user, String pwd) {
        for (User u :userList) {
            if(u.getUsername().equals(user)){
                if(u.getPassword().equals(pwd)){
                    return u;
                }
            }
        }
        return null;
    }

    public boolean withdraw(User currentUser, String amt) {
        double amount = Double.parseDouble(amt);
        if(currentUser.getBalance() >= amount && amount >= 0){
            currentUser.setBalance(currentUser.getBalance() - amount);
            recordTransaction(currentUser, Double.parseDouble(amt), true);
            return true;
        }
        return false;
    }

    public boolean deposit(User currentUser, String amt) {
        double amount = Double.parseDouble(amt);
        if(amount >= 0){
            currentUser.setBalance(currentUser.getBalance() + amount);
            recordTransaction(currentUser, amount, false);
            return true;
        }
        return false;

    }

    public boolean register(String user, String pwd) {
        User u = new User(user, pwd);
        if(userList.contains(u)){
            return false;
        }
        else{
            userList.add(new User(user, pwd));
            return true;
        }
    }

    private void recordTransaction(User currentUser, double amt, boolean isWithdrawal) {
        currentUser.addToTransactionHistory(TransactionFactory.getTransaction(amt, isWithdrawal, new Date().toString()));
    }

    public void printTransactionHistory(User user){
        for (Transaction t:user.getTransactionHistory()) {
            System.out.println(t);
        }
    }
}
