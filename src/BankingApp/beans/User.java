package BankingApp.beans;

import java.io.Serializable;

/**
 * Functionality: A bean describing a user of a bank with a username, password, account balance, and transaction history
 */
public class User implements Serializable {
    static final long serialVersionUID = 42L;
    private static User u = new User();
    private static String uname = null;

    private User(){

    }

    public static String getUname() {
        return uname;
    }

    public static void setUname(String newUname) {
        uname = newUname;
    }
}
