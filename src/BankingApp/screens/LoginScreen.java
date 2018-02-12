package BankingApp.screens;

import BankingApp.beans.User;
import BankingApp.factories.ScreenFactory;

import java.sql.*;
import java.util.Scanner;

/**
 * Functionality: Manages the screen displaying the login function.
 */
public class LoginScreen implements Screen {
    @Override
    public void prompt() {
        String user, pwd;
        String result = "";
        Scanner in = new Scanner(System.in);
        System.out.print("Username << ");
        user = in.nextLine();
        System.out.print("Password << ");
        pwd = in.nextLine();
        try (Connection c = DriverManager.getConnection("jdbc:oracle:thin:@revaturetraining.ckqxq1sfkqwb.us-east-1.rds.amazonaws.com:1521:ORCL", "bankadmin", "pass")){
            PreparedStatement ps = c.prepareStatement("SELECT login(?, ?) FROM DUAL");
            ps.setString(1, user);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = rs.getString(1);
            System.out.println("Log in successful.");
            User.setUname(user);
        } catch (SQLException e) {
            System.out.println("Log in failed.");
            e.printStackTrace();
        }
        switch (result) {
            case "VALID":
                ScreenFactory.getScreenFactory().setCurrentScreen("mainLogIn");
                break;
            case "INCORRECT_PASSWORD":
                System.out.println("Incorrect password.");
                ScreenFactory.getScreenFactory().setCurrentScreen("mainNoLogIn");
                break;
            case "NO_SUCH_USERNAME":
                System.out.println("No such username.");
                ScreenFactory.getScreenFactory().setCurrentScreen("mainNoLogIn");
                break;
        }
    }
}
