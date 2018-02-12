package BankingApp.screens;

import BankingApp.beans.User;
import BankingApp.factories.ScreenFactory;

import java.sql.*;
import java.util.Scanner;

/**
 * Functionality: Manages the withdrawal functionality.
 */
public class WithdrawScreen implements Screen {

    @Override
    public void prompt() {
        Scanner in = new Scanner(System.in);
        System.out.print("Withdrawal amount << ");
        String amt = in.nextLine();
        int result = -1;
        try (Connection c = DriverManager.getConnection("jdbc:oracle:thin:@revaturetraining.ckqxq1sfkqwb.us-east-1.rds.amazonaws.com:1521:ORCL", "bankadmin", "pass")){
            CallableStatement cs = c.prepareCall("{call withdraw(?, ?)}");
            cs.setString(1, User.getUname());
            cs.setDouble(2, Double.parseDouble(amt));
            cs.executeQuery();
            System.out.println("Withdrawal successful!");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Withdrawal failed. You may have attempted an overdraft.");
        } catch (SQLException e){
            e.printStackTrace();
        }
        ScreenFactory.getScreenFactory().setCurrentScreen("mainLogIn");
    }
}
