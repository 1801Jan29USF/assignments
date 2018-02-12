package BankingApp.screens;

import BankingApp.beans.ConnectionUtility;
import BankingApp.beans.User;
import BankingApp.factories.ScreenFactory;

import java.sql.*;

/**
 * Functionality: Manages the screen displaying the view transaction history function.
 */
public class ViewTransactionHistoryScreen implements Screen {

    @Override
    public void prompt() {
        System.out.println("Transaction History:");
        try (Connection c = ConnectionUtility.getConnection()){
            PreparedStatement ps = c.prepareStatement("SELECT t_id, is_withdrawal, amount, datetime FROM transactions WHERE responsible_user = ?");
            ps.setString(1, User.getUname());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.printf("ID: %d, %s, Date & Time: %s\n",
                        rs.getInt("t_id"),
                        (rs.getInt("is_withdrawal")) == 1 ? "Withdrawal Amount: " + rs.getDouble("amount") : "Deposit Amount: " + rs.getDouble("amount"),
                        rs.getString("datetime"));
            }
        } catch (SQLException e) {
            System.out.println("Something's wrong.");
            e.printStackTrace();
        }
        ScreenFactory.getScreenFactory().setCurrentScreen("mainLogIn");
    }
}
