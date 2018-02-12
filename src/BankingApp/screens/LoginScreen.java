package BankingApp.screens;

import BankingApp.beans.ConnectionUtility;
import BankingApp.beans.User;
import BankingApp.factories.ScreenFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        try (Connection c = ConnectionUtility.getConnection()){
            PreparedStatement ps = c.prepareStatement("SELECT login(?, ?) FROM DUAL");
            ps.setString(1, user);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = rs.getString(1);

        } catch (SQLException e) {
            System.out.println("Log in failed.");
            e.printStackTrace();
        }
        switch (result) {
            case "INVALID":
                System.out.println("Invalid credentials. Try again.");
                ScreenFactory.getScreenFactory().setCurrentScreen("mainNoLogIn");
                break;
            case "VALID":
                System.out.print("Log in successful. ");
                User.setUname(user);
                System.out.printf("Welcome back, %s.\n", User.getUname());
                ScreenFactory.getScreenFactory().setCurrentScreen("mainLogIn");
                break;
        }
    }
}
