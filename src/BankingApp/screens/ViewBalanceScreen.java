package BankingApp.screens;

import BankingApp.beans.User;
import BankingApp.factories.ScreenFactory;

import java.sql.*;

/**
 * Functionality:
 */
public class ViewBalanceScreen implements Screen {
    @Override
    public void prompt() {
        double bal = -1;
        try (Connection c = DriverManager.getConnection("jdbc:oracle:thin:@revaturetraining.ckqxq1sfkqwb.us-east-1.rds.amazonaws.com:1521:ORCL", "bankadmin", "pass")){
            PreparedStatement ps = c.prepareCall("SELECT balance FROM bank_users WHERE uname = ?");
            ps.setString(1, String.valueOf(User.getUname()));
            ResultSet rs = ps.executeQuery();
            rs.next();
            bal = rs.getDouble(1);
            System.out.printf("Current balance is: $%.2f", bal);
        } catch (SQLException e) {
            System.out.println("Something went wrong. Try again later.");
            e.printStackTrace();
        }
        ScreenFactory.getScreenFactory().setCurrentScreen("mainLogIn");
    }
}
