package com.revature.BankingApplication;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connectionUtil {
    private Properties prop = new Properties();
    private static connectionUtil connUtil = new connectionUtil();
    private connectionUtil() {
        super();
        try {
            prop.load(new FileReader("src/main/resources/database.properties"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
                prop.getProperty("pass"));
    }
    public static connectionUtil getConnectionUtil() {
        return connUtil;
    }
}