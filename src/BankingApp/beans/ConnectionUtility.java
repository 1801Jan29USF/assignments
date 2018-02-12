package BankingApp.beans;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Functionality:
 */
public class ConnectionUtility {
    private Properties prop = new Properties();
    private static ConnectionUtility connUtil = new ConnectionUtility();

    private ConnectionUtility(){
        try{
            prop.load(new FileReader("src/BankingApp/resources/database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("pass"));
    }

    public ConnectionUtility getConnUtil(){
        return connUtil;
    }
}
