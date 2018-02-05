package BankingApp.beans;

import BankingApp.factories.TransactionFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Functionality: A bean describing a bank with a list of users.
 */
public class Bank implements Serializable {
    private static Bank bank = new Bank();
    static final long serialVersionUID = 42L;
    private static ArrayList<User> userList;

    private Bank(){
        userList = new ArrayList<>();
        addUser("test", "test");
    }

    public void addUser(User u){
        userList.add(u);
    }

    public void addUser(String user, String pwd){
        addUser(new User(user, pwd));
    }

    public static void doNothing(){

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

    public boolean withdraw(User currentUser, double amount) {
        if(currentUser.getBalance() >= amount && amount >= 0){
            currentUser.setBalance(currentUser.getBalance() - amount);
            recordTransaction(currentUser, amount, true);
            return true;
        }
        return false;
    }

    public boolean deposit(User currentUser, double amount) {
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
            addUser(u);
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
