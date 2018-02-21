package BankingApp.beans;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.Serializable;

/**
 * Functionality: A singleton bean which stores a static value tracking the active user.
 */
public class User implements Serializable {
    private static Logger log = LogManager.getLogger(User.class);

    static final long serialVersionUID = 42L;
    private static User u = new User();
    private static String uname = null;

    private User(){

    }

    public static String getUname() {
        return uname;
    }

    public static void setUname(String newUname) {
        PropertyConfigurator.configure("src/BankingApp/resources/log4j.properties");
        log.setLevel(Level.DEBUG);

        log.debug("Active user changed!");
        uname = newUname;
    }
}
