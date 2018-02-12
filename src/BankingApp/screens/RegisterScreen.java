package BankingApp.screens;

import BankingApp.factories.ScreenFactory;

import java.sql.*;
import java.util.Scanner;

/**
 * Functionality: Manages the account registration screen.
 */
public class RegisterScreen implements Screen {

    @Override
    public void prompt() {
        String user, pwd;
        Scanner in = new Scanner(System.in);
        int result = -1;
        System.out.print("Username << ");
        user = in.nextLine();
        System.out.print("Password << ");
        pwd = in.nextLine();
        try (Connection c = DriverManager.getConnection("jdbc:oracle:thin:@revaturetraining.ckqxq1sfkqwb.us-east-1.rds.amazonaws.com:1521:ORCL", "bankadmin", "pass")){
            CallableStatement cs = c.prepareCall("{call registration(?, ?, ?)}");
            cs.registerOutParameter(3, result);
            cs.setString(1, user);
            cs.setString(2, pwd);
            cs.execute();
            System.out.println(cs.getInt(3));
            if(cs.getInt(3) != 1){
                System.out.println("Registration successful. Try logging in.");
            }
            else{
                System.out.println("Can't use that username. Try something else.");
            }
        } catch (SQLException e) {
            System.out.println("Something's wrong. Try another time.");
            e.printStackTrace();
        }
        ScreenFactory.getScreenFactory().setCurrentScreen("mainNoLogIn");
    }
}
