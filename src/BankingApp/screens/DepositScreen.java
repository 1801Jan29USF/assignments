package BankingApp.screens;

import BankingApp.beans.ConnectionUtility;
import BankingApp.beans.User;
import BankingApp.factories.ScreenFactory;

import java.sql.*;
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
        try (Connection c = ConnectionUtility.getConnection()){
            CallableStatement ps = c.prepareCall("{CALL deposit(?,?)}");
            ps.setString(1, String.valueOf(User.getUname()));
            ps.setDouble(2, Double.parseDouble(amt));
            ps.execute();
            System.out.println("Deposit successful!");
        }catch (SQLSyntaxErrorException e){
            System.out.println("Input must be non-negative. Try again.");
        }
        catch (SQLException e) {
            System.out.println("Deposit failed.");
            e.printStackTrace();
        }catch (NumberFormatException e){
            System.out.println("Non-number input detected.");
        }
        ScreenFactory.getScreenFactory().setCurrentScreen("mainLogIn");
    }
}
