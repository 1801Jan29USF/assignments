package BankingApp.screens;

import BankingApp.beans.User;
import BankingApp.factories.ScreenFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


/**
 * Functionality: Manages the screen displaying the deposit function.
 */
public class DepositScreen implements Screen {

    @Override
    public void prompt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Deposit amount << ");
        String amt = in.nextLine();
        try (Connection c = DriverManager.getConnection("jdbc:oracle:thin:@revaturetraining.ckqxq1sfkqwb.us-east-1.rds.amazonaws.com:1521:ORCL", "bankadmin", "pass")){
            CallableStatement ps = c.prepareCall("{CALL deposit(?,?)}");
            ps.setString(1, String.valueOf(User.getUname()));
            ps.setDouble(2, Double.parseDouble(amt));
            ps.execute();
            System.out.println("Deposit successful!");
        } catch (SQLException e) {
            System.out.println("Deposit failed.");
            e.printStackTrace();
        }
        ScreenFactory.getScreenFactory().setCurrentScreen("mainLogIn");
    }
}