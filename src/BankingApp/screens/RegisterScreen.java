package BankingApp.screens;

import BankingApp.factories.ScreenFactory;

import java.sql.*;
import java.util.Scanner;

/**
 * Functionality: Manages the screen displaying the registration function.
 */
public class RegisterScreen implements Screen {

    @Override
    public void prompt() {
        String user, pwd;
        Scanner in = new Scanner(System.in);
        System.out.print("Username << ");
        user = in.nextLine();
        System.out.print("Password << ");
        pwd = in.nextLine();
        try (Connection c = DriverManager.getConnection("jdbc:oracle:thin:@revaturetraining.ckqxq1sfkqwb.us-east-1.rds.amazonaws.com:1521:ORCL", "bankadmin", "pass")){
            CallableStatement cs = c.prepareCall("{call registration(?, ?)}");
            cs.setString(1, user);
            cs.setString(2, pwd);
            cs.execute();
            System.out.println("Registration successful. Try logging in.");
        } catch (SQLIntegrityConstraintViolationException e){
            System.out.println("You can't use a username that is already taken by another user. Try something else.");
        } catch (SQLException e) {
            System.out.println("Something's wrong. Try another time.");
            e.printStackTrace();
        }
        ScreenFactory.getScreenFactory().setCurrentScreen("mainNoLogIn");
    }
}
